(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('ConfigManageCtrl', ['$scope', '$log', 'DataService',
    'DialogService', ConfigManageCtrl
  ]);

  function ConfigManageCtrl($scope, $log, DataService, DialogService) {
    $log.debug('ConfigManageCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('ConfigManageCtrl destroy...');
    });
    $scope.query = function () {
      DialogService.showWait('配置查询中,请稍后....');
      DataService.send('/config/queryConfig', {}, function (data) {
        DialogService.hideWait();
        if (!data.success) {
          DialogService.showAlert(data.message);
          return;
        }
        $scope.tokenTimeout = data.datas.tokenTimeout;
        $scope.title = data.datas.title;
      });
    };
    $scope.query();
    $scope.saveTokenTimeout = function () {
      DialogService.showWait('配置修改中，请稍后....');
      DataService.send('/config/updateTokenTimeout', {
        config: $scope.tokenTimeout
      }, function (data) {
        DialogService.hideWait();
        DialogService.showAlert(data.message);
      });
    };

    $scope.saveTitle = function () {
      DialogService.showWait('配置修改中，请稍后....');
      DataService.send('/config/updateTitle', {
        config: $scope.title
      }, function (data) {
        DialogService.hideWait();
        DialogService.showAlert(data.message);
      });
    };
  }
})();