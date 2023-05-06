import {useContext} from "react";
import {ToastContext} from "@vuttr/context/ToastContext";


export const useToast = () => useContext(ToastContext);
