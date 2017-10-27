# 使用说明
- 首先执行reps-barrage-restful工程中db/ckplayer.sql数据库文件

- 将弹幕插件js(barrage.js)引用到自己的应用中

- 修改barrage.js CKobject.ajax 接口地址为
    1. 'http://ip:port/oapi/barrage/publish?videoId=' + videoId

    if(data){
	    var obj=eval('(' + data + ')');
        if(obj.status == 200){
            obj = obj.result;
        }
        bgArr=obj['ckplayer'];
    }

    2. CKobject.ajax 'http://localhost:9999/oapi/barrage/publish?videoId='+videoId+'&content='+encodeURIComponent(s)+'&nt='+nt


