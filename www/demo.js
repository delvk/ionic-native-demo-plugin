var DemoCharlieLoader = function(require, exports, module) {
    var exec = require('cordova/exec');
  
    var intervalId;
    
    function DemoCharlie() {}
  
    DemoCharlie.prototype.start = function(success, failure, timeOffset) {
      exec(success, failure, 'AndroidDemo', 'start', []);
      intervalId = setInterval(function() {
        exec(success, failure, 'AndroidDemo', 'getCurrent', []);
      }, timeOffset || 500);
    };
  
    DemoCharlie.prototype.stop = function(success, failure) {
      if (intervalId) {
        clearInterval(intervalId);
        intervalId = null;
      }
      exec(success, failure, 'AndroidDemo', 'stop', []);
    };
    
    var demoCharlie = new DemoCharlie();
    module.exports = deviceSensor;
  };
  
  DemoCharlieLoader (require, exports, module);
  
  cordova.define("cordova/plugin/DemoCharlie", DemoCharlieLoader );