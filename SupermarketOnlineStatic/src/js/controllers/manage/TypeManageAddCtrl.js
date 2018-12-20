(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('TypeManageAddCtrl', [
    '$scope',
    '$log',
    'DataService',
    'DialogService',
    TypeManageAddCtrl
  ]);

  function TypeManageAddCtrl($scope, $log, DataService, DialogService) {
    $log.debug('TypeManageAddCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('TypeManageAddCtrl destroy...');
    });
    $scope.formdata = {};
    $scope.close = function() {
      DialogService.hideCustom();
    };
    $scope.add = function() {
      DialogService.showWait('添加中，请稍后....');
      DataService.send('/type/add', { tbType: $scope.formdata }, function(
        data
      ) {
        DialogService.hideWait();
        if (data.success) {
          $scope.formdata = {};
        }
        DialogService.showAlert(data.message);
      });
    };
  }
})();
