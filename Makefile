## http://korea.gnu.org/manual/release/make/make-sjp/make-ko_toc.html
.PHONY : help stop-db start-db run
.DEFAULT : help

LOCAL_DB_PORT ?= 5410
LOCAL_DB_NAME ?= bookish
LOCAL_DB_PASSWORD ?= bookish
LOCAL_DB_USER := $(LOCAL_DB_NAME)
LOCAL_DB_CONTAINER := local-$(LOCAL_DB_NAME)
RUNNING_DB_CONTAINER := $(shell docker ps -f name=$(LOCAL_DB_CONTAINER) --format "{{.Names}}")

#GRADLE_FLYWAY_MIGRATION_TASKS = ./gradlew flywayMigrate

## https://gist.github.com/prwhite/8168133#gistcomment-3785627
help: ## show help message
	@awk 'BEGIN {FS = ":.*##"; printf "\nUsage:\n  make \033[36m\033[0m\n"} /^[$$()% 0-9a-zA-Z_-]+:.*?##/ { printf "  \033[36m%-15s\033[0m %s\n", $$1, $$2 } /^##@/ { printf "\n\033[1m%s\033[0m\n", substr($$0, 5) } ' $(MAKEFILE_LIST)

start-db: ## Start DB Docker Container
#ifneq ($(RUNNING_DB_CONTAINER),$(LOCAL_DB_CONTAINER))
#	@docker run --rm --name $(LOCAL_DB_CONTAINER) -d \
#	-v ${PWD}/schema:/docker-entrypoint-initdb.d \
#	-p $(LOCAL_DB_PORT):3306 \
#	-e MYSQL_PASSWORD="$(LOCAL_DB_PASSWORD)" \
#	-e MYSQL_USER="$(LOCAL_DB_USER)" \
#	-e MYSQL_DATABASE="$(LOCAL_DB_NAME)"  \
#	-e MYSQL_ALLOW_EMPTY_PASSWORD="yes" \
#	mysql
#else
ifneq ($(RUNNING_DB_CONTAINER),$(LOCAL_DB_CONTAINER))
	@docker run --rm --name $(LOCAL_DB_CONTAINER) -d \
	-v ${PWD}/schema:/docker-entrypoint-initdb.d \
	-p $(LOCAL_DB_PORT):5432 \
	-e POSTGRES_PASSWORD="$(LOCAL_DB_PASSWORD)" \
	-e POSTGRES_USER="$(LOCAL_DB_USER)" \
	-e POSTGRES_DB="$(LOCAL_DB_NAME)"  \
	postgres
else
	@echo "DB($(LOCAL_DB_CONTAINER)) is Already running."
endif


stop-db: ## Stop DB Docker Container
ifeq ($(RUNNING_DB_CONTAINER),$(LOCAL_DB_CONTAINER))
	docker stop $(LOCAL_DB_CONTAINER)
else
	@echo "DB($(LOCAL_DB_CONTAINER)) is not running"
endif

run: start-db