import {Dispatch, SetStateAction, useState} from "react";


export default function useLocalStorage<T>(keyName: string, defaultValue?: T): [T, Dispatch<SetStateAction<T>>] {
    const [storedValue, setStoredValue] = useState<T>(() => {
        try {
            const value = window.localStorage.getItem(keyName);
            if (value) {
                return JSON.parse(value);
            } else {
                if (defaultValue === null) return null;
                window.localStorage.setItem(keyName, JSON.stringify(defaultValue));
                return defaultValue;
            }
        } catch (err) {
            return defaultValue;
        }
    });

    const setValue = (value: T | ((prevState: T) => T)) => {
        if (value === null) {
            window.localStorage.removeItem(keyName);
            setStoredValue(value);
        }
        try {

            window.localStorage.setItem(keyName, JSON.stringify(value));
        } catch (err) {
        }
        setStoredValue(value);
    };

    return [storedValue, setValue];
}
