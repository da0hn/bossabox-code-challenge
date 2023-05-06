import React from "react";
import {AuthContext} from "@vuttr/context/AuthContext";


export function useAuth() {
    return React.useContext(AuthContext);
}
