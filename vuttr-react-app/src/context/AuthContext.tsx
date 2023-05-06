import React, {createContext, useEffect, useState} from "react";


interface AuthContextType {
    token: string;
    signin: (newUser: string) => void;
    signout: () => void;
}

export const AuthContext = createContext<AuthContextType>(null!);

export function AuthProvider({children}: { children: React.ReactNode }) {
    const [token, setToken] = useState<any>(null);

    useEffect(() => {
        const storedToken = localStorage.getItem('token');
        if (storedToken) {
            setToken(storedToken);
        }
    }, []);

    const signin = (newToken: string) => {
        setToken(newToken);
        localStorage.setItem('token', newToken);
    };

    const signout = () => {
        setToken(null);
        localStorage.removeItem('token');
    }

    const value = {token, signin, signout};

    return (
        <AuthContext.Provider value={value}>
            {children}
        </AuthContext.Provider>
    )
}
