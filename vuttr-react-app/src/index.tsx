import React from 'react';
import ReactDOM from 'react-dom/client';
import {RouterProvider} from "react-router-dom";
import {router} from "@vuttr/routes/router";

import '@vuttr/styles/globals.css';
import "primereact/resources/themes/mira/theme.css";
import "primereact/resources/primereact.min.css";
import "primeicons/primeicons.css";
import {QueryClient, QueryClientProvider} from "@tanstack/react-query";
import {AuthProvider} from "@vuttr/context/AuthContext";

const queryClient = new QueryClient();

const root = ReactDOM.createRoot(
    document.getElementById('root') as HTMLElement
);
root.render(
    <React.StrictMode>
        <QueryClientProvider client={queryClient}>
            <AuthProvider>
                <RouterProvider router={router}></RouterProvider>
            </AuthProvider>
        </QueryClientProvider>
    </React.StrictMode>
);

