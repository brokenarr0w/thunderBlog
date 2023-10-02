export default {
    saveClientSize(state, clientSize){
        state.clientSize = clientSize;
    },
    saveIntroduction(state,introduction){
        state.introduction = introduction
    },
    saveToken(state,token){
        localStorage.setItem('token',token)
        state.Token = token
    },
    saveSiteInfo(state,siteInfo){
        state.siteInfo = siteInfo
    },
    saveisBlogFinished(state,isBlogFinished){
        state.isBlogFinished = isBlogFinished
    }
}