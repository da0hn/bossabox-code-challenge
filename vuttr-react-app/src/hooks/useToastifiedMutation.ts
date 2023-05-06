import {UseMutationOptions, UseMutationResult} from "@tanstack/react-query/src/types";
import {useMutation} from "@tanstack/react-query";
import {useToast} from "@vuttr/hooks/useToast";
import {AxiosError} from "axios";
import {ApiErrorResponse} from "@vuttr/types/VuttrResponseWrappers";


export function useToastifiedMutation<
    TData = unknown,
    TError = unknown,
    TVariables = void,
    TContext = unknown,
>(
    options: UseMutationOptions<TData, TError, TVariables, TContext>,
    extraOptions?: {
        messageOnSuccess?: string,
    }
): UseMutationResult<TData, TError, TVariables, TContext> {

    const toast = useToast();

    const handleMutationComplete = (
        data: TData,
        variables: TVariables,
        context: TContext | undefined,
    ) => {
        toast.show({
            severity: 'success',
            summary: 'Operation success',
            detail: extraOptions?.messageOnSuccess ?? 'Operation performed successfully'
        })

        if (options?.onSuccess) {
            options.onSuccess(data, variables, context);
        }
    };

    const handleMutationError = (
        error: TError,
        variables: TVariables,
        context: TContext | undefined
    ) => {

        const apiError = (error as AxiosError<ApiErrorResponse<any>>).response?.data;

        toast.show({
            severity: 'error',
            summary: 'Error occurred',
            detail: apiError?.data.detail ?? 'A unexpected error occurs'
        })
        if (options?.onError) {
            options.onError(error, variables, context);
        }
    }

    const mutation = useMutation<TData, TError, TVariables, TContext>(
        {
            ...options,
            onSuccess: handleMutationComplete,
            onError: handleMutationError
        }
    );

    return {
        ...mutation,
    };
}
