import React from 'react';
import ReactDOM from 'react-dom/client';

import '@vuttr/styles/globals.css';
import "primereact/resources/themes/mira/theme.css";
import "primereact/resources/primereact.min.css";
import "primeicons/primeicons.css";
import {QueryClient, QueryClientProvider} from "@tanstack/react-query";
import {ToastProvider} from "@vuttr/context/ToastContext";
import Router from "@vuttr/routes/router";
import {AuthProvider} from "@vuttr/context/AuthContext";

const queryClient = new QueryClient();

const root = ReactDOM.createRoot(
    document.getElementById('root') as HTMLElement
);
root.render(
    <React.StrictMode>
        <QueryClientProvider client={queryClient}>
            <AuthProvider>
                <ToastProvider>
                    <Router/>
                </ToastProvider>
            </AuthProvider>
        </QueryClientProvider>
    </React.StrictMode>
);

