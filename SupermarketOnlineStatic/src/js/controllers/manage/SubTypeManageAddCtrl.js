(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('SubTypeManageAddCtrl', ['$scope', '$log', 'DataService',
    'DialogService', SubTypeManageAddCtrl
  ]);

  function SubTypeManageAddCtrl($scope, $log, DataService, DialogService) {
    $log.debug('SubTypeManageAddCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('SubTypeManageAddCtrl destroy...');
    });

    var cdata = DialogService.getCustomData();
    $scope.types = [{
      tid: -1,
      typeName: '----请选择分类-----'
    }].concat(cdata.types);
    $scope.formdata = {
      tid: $scope.types[0].tid
    };
    $scope.close = function () {
      DialogService.hideCustom();
    };
    $scope.add = function () {
      DialogService.showWait('添加数据中，请稍后.....')
      DataService.send('/subtype/add', {
        TbSubType: $scope.formdata
      }, function (data) {
        DialogService.hideWait();
        if (data.success) {
          $scope.formdata = {
            tid: $scope.types[0].tid
          };
        }
        DialogService.showAlert(data.message);
      });
    };
  }
})();