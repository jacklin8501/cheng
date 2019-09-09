CREATE TABLE AH_USER (
    USERNAME VARCHAR(100) NOT NULL PRIMARY KEY,
    PASSWORD VARCHAR(255) NOT NULL
);

-- Insert rows into table 'TableName'
INSERT INTO AH_USER
( -- columns to insert data into
 USERNAME, PASSWORD
)
VALUES
( -- first row: values for the columns in the list above
 'XIAOHUIHUI', '123'
),
( -- second row: values for the columns in the list above
 'XIAOJ8HUI', '456'
),
( -- second row: values for the columns in the list above
 'XIAOHUIDOG', '789'
);
-- add more rows here

-- Create the table in the specified schema
CREATE TABLE AH_ROLE
(
    ROLENAME VARCHAR(100) NOT NULL PRIMARY KEY,
    DESCRIPTION NVARCHAR(1000) NULL
);

-- Insert rows into table 'TableName'
INSERT INTO AH_ROLE
( -- columns to insert data into
 ROLENAME, DESCRIPTION
)
VALUES
( -- first row: values for the columns in the list above
 'MAXADMIN', null
),
( -- second row: values for the columns in the list above
 'ADMIN', null
),
( -- second row: values for the columns in the list above
 'USER', null
);
-- add more rows here

-- Create the table in the specified schema
CREATE TABLE MID_USER_ROLE
(
    USERNAME VARCHAR(100) NOT NULL,
    ROLENAME VARCHAR(100) NOT NULL,

    CONSTRAINT PK_MID_USER_ROLE PRIMARY KEY(USERNAME,ROLENAME)
);

-- Insert rows into table 'TableName'
INSERT INTO MID_USER_ROLE
( -- columns to insert data into
 USERNAME, ROLENAME
)
VALUES
( -- first row: values for the columns in the list above
 'XIAOHUIHUI', 'MAXADMIN'
),
( -- second row: values for the columns in the list above
 'XIAOHUIHUI', 'ADMIN'
),
( -- second row: values for the columns in the list above
 'XIAOHUIHUI', 'USER'
),
( -- first row: values for the columns in the list above
 'XIAOJ8HUI', 'MAXADMIN'
),
( -- second row: values for the columns in the list above
 'XIAOJ8HUI', 'ADMIN'
),
( -- second row: values for the columns in the list above
 'XIAOJ8HUI', 'USER'
),
( -- first row: values for the columns in the list above
 'XIAOHUIDOG', 'MAXADMIN'
),
( -- second row: values for the columns in the list above
 'XIAOHUIDOG', 'ADMIN'
),
( -- second row: values for the columns in the list above
 'XIAOHUIDOG', 'USER'
);
-- add more rows here

-- Create the table in the specified schema
CREATE TABLE AH_PERM
(
    PERMNAME VARCHAR(100) NOT NULL PRIMARY KEY, -- primary key column
    URI VARCHAR(100) NOT NULL,
    DESCRIPTION NVARCHAR(1000) NULL
);

-- Insert rows into table 'TableName'
INSERT INTO AH_PERM
( -- columns to insert data into
 PERMNAME, URI, DESCRIPTION
)
VALUES
( -- first row: values for the columns in the list above
 'USER:SELECT:ONE', '/user/select/one', NULL
),
( -- second row: values for the columns in the list above
 'USER:SELECT:PAGE', '/user/select/page', NULL
),
( -- second row: values for the columns in the list above
 'USER:EDIT', '/user/edit', NULL
);
-- add more rows here

-- Create the table in the specified schema
CREATE TABLE MID_ROLE_PERM
(
    PERMNAME VARCHAR(100) NOT NULL,
    ROLENAME VARCHAR(100) NOT NULL,

    CONSTRAINT PK_MID_ROLE_PERM PRIMARY KEY(PERMNAME,ROLENAME)
);

-- Insert rows into table 'TableName'
INSERT INTO MID_ROLE_PERM
( -- columns to insert data into
 PERMNAME, ROLENAME
)
VALUES
( -- first row: values for the columns in the list above
 'USER:SELECT:ONE', 'MAXADMIN'
),
( -- second row: values for the columns in the list above
 'USER:SELECT:PAGE', 'MAXADMIN'
),
( -- second row: values for the columns in the list above
 'USER:EDIT', 'MAXADMIN'
),
( -- first row: values for the columns in the list above
 'USER:SELECT:ONE', 'ADMIN'
),
( -- second row: values for the columns in the list above
 'USER:SELECT:PAGE', 'ADMIN'
),
( -- second row: values for the columns in the list above
 'USER:EDIT', 'ADMIN'
),
( -- first row: values for the columns in the list above
 'USER:SELECT:ONE', 'USER'
),
( -- second row: values for the columns in the list above
 'USER:SELECT:PAGE', 'USER'
),
( -- second row: values for the columns in the list above
 'USER:EDIT', 'USER'
);
-- add more rows here