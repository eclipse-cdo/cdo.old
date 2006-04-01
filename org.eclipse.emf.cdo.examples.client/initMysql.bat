@echo off

set USER=test
set PASSWORD=test
set DATABASE=cdoTest

mysql -u %USER% -p%PASSWORD% -e "drop database if exists %DATABASE%; create database %DATABASE%" mysql
