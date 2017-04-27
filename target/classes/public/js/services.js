angular.module('app.services', []).factory('Fixture', function($resource) {
  return $resource('/api/v1/fixtures/:id', { id: '@id' }, {
	query:  {method:'GET', isArray:true},  
    update: {
      method: 'PUT'
    }
  });
}).factory('Customer', function($resource) {
	  return $resource('/api/v1/customers/:id', { id: '@id' }, {
	    update: {
	      method: 'PUT'
	    }
	  });
}).factory('HeadToHead', function($resource) {
	  return $resource('/api/v1/headtohead/:id', { id: '@id' }, {
	    update: {
	      method: 'PUT'
	    }
	  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});

