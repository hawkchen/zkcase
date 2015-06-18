/**
 * 1. Tree should have scalss="dottree"
 * 2. treecell should have label (treecell label)
 * 3. if there are images in a Treecell, preload images is required to makes calculation for positions correctly
 */
function generateDotLines (tree) {
	jq('.lines-container').each(function () {
		this.parentNode.removeChild(this);
	});
	// items: all visible treeitem
	var items = tree.getItems({skipHidden: true}),
		len = items.length,
		idx = 0,
		itemsToGenerate = [];
	for ( ; idx < len; idx++) {
		var item = items[idx],
			level = item.getLevel();
		if (level > 0) {// has parent
			var w = item.getParentItem();
			if (w.treechildren.firstChild == item) {
				// push parent item to array
				itemsToGenerate.push(w);
			}
		}
	}
	var container = insertChildDiv(tree),
		coffset = jq(container).offset(),
		ctop = coffset.top,
		cleft = coffset.left;
	len = itemsToGenerate.length;
	idx = 0;

	// add dot lines
	for ( ; idx < len; idx++) {
		var item = itemsToGenerate[idx],
			w = item.treechildren.firstChild,
			$picon = jq(item.$n('icon')),
			tcurr = $picon.offset().top + $picon.outerHeight(true),
			lcurr = $picon.offset().left - cleft;

		while (w) {
			var $w = jq(w.$n()),
				oend = $w.offset(),
				tend = oend.top + $w.height()/2 + 2,
				lend = jq(w.getFirstCell()).find('.z-tree-icon')[0] ?
					jq(jq(w.getFirstCell()).find('.z-tree-icon')[0]).offset().left
					: jq(jq(w.getFirstCell()).find('.z-treecell-text')[0]).offset().left,
				lend = lend - cleft,
				tdiff = tend - tcurr - 13,
				cls = (item.treechildren.lastChild == w)? 'item-last' : 'item-branch';

			while (tdiff > 0) {
				var h = tdiff > 100 ? 100 : tdiff,
					lineDiv = getLineDiv('line', tcurr - ctop, lcurr, h, lend - lcurr);
				container.appendChild(lineDiv);
				tcurr += h;
				tdiff -= 100;
			}
			container.appendChild(getLineDiv(cls, tcurr - ctop, lcurr, 20, lend - lcurr));
			tcurr += 20;
			w = w.nextSibling;
		}
	}
}
function insertChildDiv (tree) {
	var div = document.createElement('div');
	jq(div).addClass('lines-container');
	tree.$n('body').insertBefore(div, tree.$n('body').firstChild);
	return div;
}
function getLineDiv (cls, top, left, height, width) {
	var div = document.createElement('div');
	jq(div).addClass(cls)
		.css({
			'position': 'absolute',
			'top': top+'px',
			'left': left+'px',
			'height': height+'px',
			'width': width+'px'
		});
	return div;
}
zk.afterLoad('zul.sel', function () {
	var _wgt = {};
	zk.override(zul.sel.Tree.prototype, _wgt, {
		bind_: function (a, b, c) {
			_wgt.bind_.apply(this, arguments);
			var sclass = this.getSclass();
			if (sclass && sclass.indexOf('dottree') > -1)
				generateDotLines(this);
		},
		_sizeOnOpen: function () {
			_wgt._sizeOnOpen.apply(this, arguments);
			var sclass = this.getSclass();
			if (sclass && sclass.indexOf('dottree') > -1)
				generateDotLines(this);
		},
		onSize: function () {
			_wgt.onSize.apply(this, arguments);
			var sclass = this.getSclass();
			if (sclass && sclass.indexOf('dottree') > -1){
				if (zUtl.isImageLoading() || zk.clientinfo) {
					setTimeout(arguments.callee.bind(this), 20);
					return;
				}
				generateDotLines(this);
			}
		},
	});
});