import vuex from "@/store/index";

export default function getPageTitle(pageTitle) {
    
    const title = vuex.state.siteInfo.webTitleSuffix

    if (pageTitle) {
        if (title) {
            return `${pageTitle}${title}`
        }
        return pageTitle
    }
    return title
}