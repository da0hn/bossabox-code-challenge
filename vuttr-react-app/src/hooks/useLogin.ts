import {apiClient} from "@vuttr/services/ApiClient";
import {ApiResponse} from "@vuttr/types/VuttrResponseWrappers";
import {useToastifiedMutation} from "@vuttr/hooks/useToastifiedMutation";


type UserLoginResponse = { token: string };

type LoginParameters = {
    login: string,
    password: string
}

const doLogin = async (parameters: LoginParameters): Promise<ApiResponse<UserLoginResponse>> => {
    const {data, status} = await apiClient.post<ApiResponse<UserLoginResponse>>(
        '/users/login',
        parameters
    );
    return data;
}


export function useLogin() {
    const query = useToastifiedMutation(
        {
            mutationFn: doLogin,
            mutationKey: ['user-login'],
            retry: false
        },
        {
            messageOnSuccess: 'Successful login',
        }
    );
    return {
        ...query,
        data: query.data?.data,
    };
}

