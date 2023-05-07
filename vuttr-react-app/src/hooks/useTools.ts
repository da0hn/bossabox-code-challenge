import {ApiCollectionResponse} from "@vuttr/types/VuttrResponseWrappers";
import {apiClient} from "@vuttr/services/ApiClient";
import {useQuery} from "@tanstack/react-query";
import {useAuth} from "@vuttr/hooks/useAuth";

export type ToolTableItem = {
    id: number,
    title: string,
    link: string,
    description: string,
    tags: string[]
}

export type FetchToolsParameters = {
    token: string,
}

const doFetchTools = async ({token}: FetchToolsParameters): Promise<ApiCollectionResponse<ToolTableItem>> => {
    const {data, status} = await apiClient.get<ApiCollectionResponse<ToolTableItem>>(
        '/tools',
        {
            headers: {
                Authorization: `Bearer ${token}`
            }
        }
    );
    return data;
}

export default function useTools() {
    const {token} = useAuth();
    const query = useQuery({
        queryFn: async () => {
            return await doFetchTools(<FetchToolsParameters>{token});
        },
        queryKey: ['fetch-tools'],
    });
    return {
        ...query,
        data: query.data?.data
    };
}
