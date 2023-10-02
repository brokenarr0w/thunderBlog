export const responseSuccess = response => {
    // eslint-disable-next-line yoda
    // 这里没有必要进行判断，axios 内部已经判断
    // const isOk = 200 <= response.status && response.status < 300
    return Promise.resolve(response.data)
}