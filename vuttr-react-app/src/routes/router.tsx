import {createBrowserRouter} from "react-router-dom";
import Login from "@vuttr/pages/Login";

export const router = createBrowserRouter([
    {
        path: '/',
        element: <Login/>,
    }
]);

