#!/bin/bash

# create and init database
mysql -u root < ./create_and_init_db/db_create.sql
echo "init done"
