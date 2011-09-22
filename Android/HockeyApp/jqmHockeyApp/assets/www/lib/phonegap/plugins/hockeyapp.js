var hockeyApp = function(){};

var passCb = function(){
    alert('passCb');
};

var failCb = function(){
    alert('failCb');
};


checkForUpdate.prototype.hockeyApp = function(){
    return PhoneGap.exec(function(){
        passCb(),
        failCb(),
        'HockeyApp', 'checkForUpdate', []
    });
};

PhoneGap.addConstructor(function() {
	PhoneGap.addPlugin('HockeyApp', new hockeyApp());
	PluginManager.addService("HockeyApp","com.moxoed.pgPlugin.hockeyapp.HockeyApp");
});