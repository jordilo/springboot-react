import {useEffect, useState} from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import {EntityLoad,} from "./types.ts";
import {getAllUsers, PaginationUserList} from "./models";


function App() {
    const size = 3;
    const [page, setPage] = useState(0)
    const [usersList, setUsersList] = useState<EntityLoad<PaginationUserList>>({status: 'loading'});

    useEffect(() => {
            getAllUsers({query: {page, size}})
                .then(res => {
                    if (res.data) {
                        setUsersList({status: 'success', data: res.data});
                    } else {
                        setUsersList({status: 'error'});
                    }
                })
                .catch(_ => setUsersList({status: 'error'}));

        },
        [size, page]
    )

    return (
        <>
            <div>
                <a href="https://vite.dev" target="_blank">
                    <img src={viteLogo} className="logo" alt="Vite logo"/>
                </a>
                <a href="https://react.dev" target="_blank">
                    <img src={reactLogo} className="logo react" alt="React logo"/>
                </a>
            </div>
            <h1>Vite + React</h1>
            <div className="card">
                {usersList.status === 'loading' && <p>Loading...</p>}
                <ul>
                    {usersList.status === 'success' && usersList.data?.items.map((user) => <li>{user.username}</li>)}
                </ul>

                <button disabled={page <= 0} onClick={() => setPage((pagination) => --pagination)}>
                    Previous Page
                </button>
                <span>Current page {page + 1}</span>
                <button disabled={usersList.status === 'success' && usersList.data?.lastPage}
                        onClick={() => setPage((pagination) => ++pagination)}>
                    Next Page
                </button>
            </div>
            <p className="read-the-docs">
                Click on the Vite and React logos to learn more
            </p>
        </>
    )
}

export default App
