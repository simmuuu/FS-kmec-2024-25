# Role Based Access Control in Snowflake

## Default Important Roles
- ACCOUNTADMIN
- SECURITYADMIN
- SYSADMIN
- USERADMIN
- PUBLIC

## commands
- GRANT ROLE role to USER user;
- GRANT ROLE child to ROLE parent
- REVOKE ROLE role FROM USER user;
- GRANT SELECT ON TABLE schema.table TO ROLE role;
- GRANT ALL PRIVILEGES.......
- REVOKE USAGE ON WAREHOUSE warehouse FROM ROLE role;
- USE role role_name (one active role per session)
- SHOW GRANTS for users and roles

## Best Practices
- Least Privilege Principle
- Avoid daily use of ACCOUNTADMIN
- Audit grants regularly
- Create custom roles for departments

