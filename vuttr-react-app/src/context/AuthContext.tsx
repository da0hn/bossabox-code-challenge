import React, {createContext, useMemo} from "react";
import {Navigate, Outlet, useLocation} from "react-router-dom";
import useLocalStorage from "@vuttr/hooks/useLocalStorage";
import {useAuth} from "@vuttr/hooks/useAuth";


interface AuthContextType {
    token?: string | null;
    signin: (newToken: string, callback?: VoidFunction) => void;
    signout: (callback?: VoidFunction) => void;
}


export const AuthContext = createContext<AuthContextType>(null!);


export function AuthProvider({children}: { children: React.ReactNode }) {
    // https://www.robinwieruch.de/react-router-private-routes/
    const [token, setToken] = useLocalStorage<string>('token', null!);

    const signin = (newToken: string, callback?: VoidFunction) => {
        setToken(newToken);
        callback?.();
    };

    const signout = (callback?: VoidFunction) => {
        setToken(null!);
        callback?.();
    }

    const value = useMemo(
        () => ({token, signin, signout}),
        [token]
    );

    return (
        <AuthContext.Provider value={value}>
            {children}
        </AuthContext.Provider>
    )
}

export function AuthGuard({children}: { children: JSX.Element }) {
    const auth = useAuth();
    const location = useLocation();

    if (!auth.token) {
        return (
            <Navigate to='/login' state={{from: location}} replace/>
        )
    }

    return children ? children : <Outlet/>;
}
