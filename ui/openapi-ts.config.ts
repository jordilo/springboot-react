import {defineConfig} from '@hey-api/openapi-ts';

export default defineConfig({
    client: '@hey-api/client-axios',
    input:
        'http://localhost:8080/api-docs.yaml',
    output: {
        format: 'prettier',
        lint: 'eslint',
        path: './src/models',
    },
    request: 'http://localhost:8080'
});


