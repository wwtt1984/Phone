var Phone = function () {};
/**
 * 设置提示值
 * @param phonenum
 * @returns {*}
 */
Vpn.prototype.Call = function (phonenum,callback) {
    return cordova.exec(callback, null,"PhonePlugin","Call",[phonenum]);
};

Vpn.prototype.Abort = function (callback) {
    return cordova.exec(callback, null,"PhonePlugin","Abort",[]);
};

module.exports = (new Phone());
