export interface ApiResponse<T> {
    data: T,
    success: boolean
}

export interface ApiCollectionResponse<T> {
    data: T[],
    success: boolean
}

export interface ApiErrorResponse<T> {
    data: T,
    message: string,
    time: Date
}
