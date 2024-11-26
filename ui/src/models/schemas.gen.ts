// This file is auto-generated by @hey-api/openapi-ts

export const UserSchema = {
    required: ['email', 'password', 'username'],
    type: 'object',
    properties: {
        id: {
            type: 'string'
        },
        username: {
            type: 'string'
        },
        password: {
            type: 'string'
        },
        email: {
            type: 'string'
        },
        avatar: {
            type: 'string'
        }
    }
} as const;

export const PaginationUserListSchema = {
    required: ['currentPage', 'items', 'pageSize', 'totalItems'],
    type: 'object',
    properties: {
        items: {
            type: 'array',
            items: {
                '$ref': '#/components/schemas/UserList'
            }
        },
        currentPage: {
            type: 'integer',
            format: 'int32'
        },
        totalItems: {
            type: 'integer',
            format: 'int32'
        },
        pageSize: {
            type: 'integer',
            format: 'int32'
        },
        lastPage: {
            type: 'boolean'
        }
    }
} as const;

export const UserListSchema = {
    type: 'object',
    properties: {
        id: {
            type: 'string'
        },
        username: {
            type: 'string'
        }
    }
} as const;