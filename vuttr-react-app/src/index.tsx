import React from 'react';
import ReactDOM from 'react-dom/client';
import {RouterProvider} from "react-router-dom";
import {router} from "@vuttr/routes/router";

import '@vuttr/styles/globals.css';
import "primereact/resources/themes/mira/theme.css";
import "primereact/resources/primereact.min.css";
import "primeicons/primeicons.css";

const root = ReactDOM.createRoot(
    document.getElementById('root') as HTMLElement
);
root.render(
    <React.StrictMode>
        <RouterProvider router={router}></RouterProvider>
    </React.StrictMode>
);

