#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    create database cinemille;
    create user cinemille with encrypted password 'cinemille';
    grant all privileges on database cinemille to cinemille;
EOSQL

cd /init_sql

psql -U cinemille < /init_sql/cine_mille_init.sql
