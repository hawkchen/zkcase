/*
 * avoid secutive clicking.
 */
zk.afterLoad('zul.sel', function () {
	var _oldDoClick = {};
	zk.override(zul.sel.Treeitem.prototype, _oldDoClick, {
		doClick_: function (evt, popupOnly) {
			if (evt.domEvent.originalEvent.detail >1){
				return;
			}
			_oldDoClick.doClick_.apply(this, arguments); //call the original method
		}
	});
});