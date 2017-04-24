angular.module('app.services', []).factory('Fixture', function($resource) {
  return $resource('/api/v1/fixtures/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
