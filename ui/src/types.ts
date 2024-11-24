import {components} from "./models";

export type EntityLoad<T extends object> = { status: 'loading' | 'error' } | { status: 'success', data: T };
export type Pagination<T extends object> = Omit<components["schemas"]["PaginationUserList"], 'items'> & { items: T[] };
export type User = components["schemas"]["User"];
export type UserList = components["schemas"]["UserList"];