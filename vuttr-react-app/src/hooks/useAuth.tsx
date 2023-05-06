import React from "react";
import {AuthContext} from "@vuttr/context/AuthContext";


export default function useAuth() {
    return React.useContext(AuthContext);
}
