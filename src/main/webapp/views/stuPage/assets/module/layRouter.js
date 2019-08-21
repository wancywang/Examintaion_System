/** EasyWeb spa v3.1.2 date:2019-06-05 License By http://easyweb.vip */

layui.define(function(d) {
	var a = [];
	var f, c = location.hash;
	var e = function(j) {
			var h;
			var g = "";
			if (j) {
				g = j;
				h = layui.router("#" + j)
			} else {
				h = layui.router();
				for (var k = 0; k < h.path.length; k++) {
					g += ("/" + h.path[k])
				}
			}
			if (!g || g == "/") {
				if (f) {
					location.replace("#" + f)
				}
			} else {
				if (g) {
					for (var k = 0; k < a.length; k++) {
						if (h.href.match(a[k])) {
							g = a[k];
							break
						}
					}
					if (b.pop) {
						b.pop.call(this, h)
					}
					b.lash = h.href;
					if (b[g]) {
						b[g].call(this, h)
					} else {
						if (b.notFound) {
							b.notFound.call(this, h)
						}
					}
				}
			}
		};
	var b = {
		isRefresh: false,
		init: function(g) {
			f = g.index;
			if (g.pop && typeof g.pop == "function") {
				b.pop = g.pop
			}
			if (g.notFound && typeof g.notFound == "function") {
				b.notFound = g.notFound
			}
			e();
			return this
		},
		reg: function(j, g) {
			if (!j) {
				return
			}
			if (g == undefined) {
				g = function() {}
			}
			if (j instanceof RegExp) {
				b[j] = g;
				a.push(j)
			} else {
				if (j instanceof Array) {
					for (var h in j) {
						this.reg.apply(this, [].concat(j[h]).concat(g))
					}
				} else {
					if (typeof j == "string") {
						if (typeof g == "function") {
							b[j] = g
						} else {
							if (typeof g == "string" && b[g]) {
								b[j] = b[g]
							}
						}
					}
				}
			}
			return this
		},
		go: function(g) {
			location.hash = "#" + g
		},
		refresh: function(g) {
			b.isRefresh = true;
			e(g);
			b.isRefresh = false
		}
	};
	setInterval(function() {
		if (c != location.hash) {
			c = location.hash;
			e()
		}
	}, 100);
	d("layRouter", b)
});