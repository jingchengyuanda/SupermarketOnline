(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('TypeManageCtrl', [
    '$scope',
    '$log',
    'DataService',
    'DialogService',
    TypeManageCtrl
  ]);

  function TypeManageCtrl($scope, $log, DataService, DialogService) {
    $log.debug('TypeManageCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('TypeManageCtrl destroy...');
    });

    $scope.page = {
      pageNumber: 1,
      PageSize: 5
    };

    $scope.query = function () {
      DialogService.showWait('数据查询中....');
      DataService.send('/type/queryAll', {
        page: $scope.page
      }, function (data) {
        DialogService.hideWait();
        if (data.success) {
          $scope.list = data.datas.list;
          $scope.page = data.datas.page;
        }
      });
    };
    $scope.query();
    /*分页 */
    $scope.ToPage = function (pn) {

      if (
        pn <= 0 ||
        pn > $scope.page.pageCount ||
        pn == $scope.page.pageNumber
      ) {
        return;
      }
      //分页查询
      $scope.page.pageNumber = pn;
      $scope.query();
    };

    //添加
    $scope.Toadd = function () {
      //临时添加标题
      DialogService.setTempDialogTitle('添加类型');
      DialogService.showCustom(
        'templates/manage/typemanage-add.html', {},
        function (data) {
          $scope.query();
        }
      );
    };

    //刪除
    $scope.toDelete = function (type) {
      DialogService.showConfirm('是否禁用：' + type.typeName + '?', function () {
        DialogService.showWait('禁用中，请稍后...');
        DataService.send('/type/delete', {
          tbType: type
        }, function (data) {
          DialogService.hideWait();
          DialogService.showAlert(data.message, function () {
            if (data.success)
              $scope.query();
          });
        });
      });
    };



    //启用
    $scope.toUnDelete = function (type) {
      DialogService.showConfirm('是否启用：' + type.typeName + '?', function () {
        DialogService.showWait('启用中，请稍后...');
        DataService.send('/type/undelete', {
          tbType: type
        }, function (data) {
          DialogService.hideWait();
          DialogService.showAlert(data.message, function () {
            if (data.success)
              $scope.query();
          });
        });
      });
    };

    //修改
    $scope.toUpdate = function (type) {

      DialogService.setTempDialogTitle('修改类型数据');
      DialogService.showCustom(
        'templates/manage/typemanage-updata.html', type,
        function (data) {
          $scope.query();
        }
      );
    };


  }
})();