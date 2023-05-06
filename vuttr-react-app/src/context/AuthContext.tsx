import React, {createContext, useContext, useState} from "react";
import {Navigate, Outlet, useLocation} from "react-router-dom";


interface AuthContextType {
    token?: string | null;
    authenticated: boolean,
    signin: (newToken: string, callback?: VoidFunction) => void;
    signout: (callback?: VoidFunction) => void;
}

export const AuthContext = createContext<AuthContextType>({
    token: null,
    authenticated: false,
    signin: (newToken) => {
    },
    signout: () => {
    },
});


export function AuthProvider({children}: { children: React.ReactNode }) {
    const [token, setToken] = useState<string>(null!);
    const [authenticated, setAuthenticated] = useState<boolean>(false);

    const signin = (newToken: string, callback?: VoidFunction) => {
        setToken(newToken);
        setAuthenticated(true);
        localStorage.setItem('token', newToken);
        callback?.();
    };

    const signout = (callback?: VoidFunction) => {
        setToken(null!);
        setAuthenticated(false);
        localStorage.removeItem('token');
        callback?.();
    }

    const value = {token, authenticated, signin, signout};

    return (
        <AuthContext.Provider value={value}>
            {children}
        </AuthContext.Provider>
    )
}

export function AuthGuard({children}: { children: JSX.Element }) {
    const auth = useContext(AuthContext);
    const location = useLocation();

    console.log(auth);

    if (!auth.token) {
        return (
            <Navigate to='/login' state={{from: location}} replace/>
        )
    }

    return children ? children : <Outlet/>;
}
