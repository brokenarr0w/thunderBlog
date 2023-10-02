import Vuex from 'vuex'
import state from "@/store/state";
import mutations from "@/store/mutations";
import actions from "@/store/actions"
const vuex = new Vuex.Store({
    state,
    mutations,
    actions,
})
export default vuex