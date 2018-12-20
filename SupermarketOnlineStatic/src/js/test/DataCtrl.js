(function() {
  var ctrls = angular.module('controllers');
  ctrls.controller('TestDataCtrl', [
    '$scope',
    '$log',
    'DataService',
    TestDataCtrl
  ]);

  function TestDataCtrl($scope, $log, DataService) {
    $log.debug('TestDataCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('TestDataCtrl destroy...');
    });

    DataService.setDataServer('http://127.0.0.1:14000');

    $scope.formdata = {};

    $scope.sendData = function() {
      DataService.send('/', { test: $scope.formdata }, function(data) {
        $scope.result = data;
      });
    };
  }
})();
