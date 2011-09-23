var hockeyApp = function(){};

var passCb = function(){
    alert('passCb');
};

var failCb = function(){
    alert('failCb');
};


hockeyApp.prototype.checkForUpdate = function(){
    return PhoneGap.exec(passCb, failCb, 'HockeyApp', 'checkForUpdate', []);
};

PhoneGap.addConstructor(function() {
	PhoneGap.addPlugin('HockeyApp', new hockeyApp());
	PluginManager.addService("HockeyApp","com.moxoed.pgPlugin.hockeyapp.HockeyApp");
});