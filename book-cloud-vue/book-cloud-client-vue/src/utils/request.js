import axios from 'axios'
import router from '../router'

axios.interceptors.response.use(success => {
    if (success.status && success.status == 200 && success.data.status == 500) {
        alert(success.data.msg);
        return;
    }
    return success.data;
}, error => {
    if (error.response.status == 504 || error.response.status == 404) {
        alert('服务器迷路了( ╯□╰ )，再试一次吧。');
    } else if (error.response.status == 403) {
        alert('权限不足，请联系管理员');
    } else if (error.response.status == 401) {
        // 防止重复弹出消息
        if(db.get("LOGINFLAG") == "0"){
            alert('尚未登录或登录状态已过期，请登录')
            db.remove("LOGINFLAG")
            db.save("LOGINFLAG","1")
        }
        router.replace('/');
    } else if (error.response.status == 429) {
        alert('骚年，你的手速有点快哦！(￣.￣)...')
    } else {
        alert('未知错误!')
    }
    return;
})