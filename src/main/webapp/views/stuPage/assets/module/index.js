/** EasyWeb spa v3.1.2 date:2019-06-05 License By http://easyweb.vip */

layui.define(["layer", "element", "config", "layRouter", "admin", "contextMenu"], function(t) {
	var d = layui.jquery;
	var s = layui.layer;
	var b = layui.element;
	var q = layui.config;
	var l = layui.layRouter;
	var k = layui.admin;
	var u = layui.contextMenu;
	var a = ".layui-layout-admin>.layui-header";
	var n = ".layui-layout-admin>.layui-side>.layui-side-scroll";
	var i = ".layui-layout-admin>.layui-body";
	var m = i + ">.layui-tab";
	var r = i + ">.layui-body-header";
	var h = "admin-pagetabs";
	var o = "admin-side-nav";
	var c;
	var g = {
		mTabPosition: undefined,
		mTabList: [],
		regRouter: function(v) {
			d.each(v, function(x, y) {
				if (y.url && y.url.indexOf("#") == 0) {
					var w = g.getHashPath(y.url);
					l.reg(w, function(z) {
						g.loadView({
							menuId: z.href,
							menuPath: q.viewPath + w + g.getViewSuffix(w),
							menuName: y.name
						})
					})
				}
				if (y.subMenus) {
					g.regRouter(y.subMenus)
				}
			})
		},
		loadView: function(x) {
			var B = x.menuId;
			var v = x.menuPath;
			var w = x.menuName;
			var D = g.getHashPath("#" + B);
			var z = i + ">div[lay-id]";
			if (q.pageTabs) {
				var E;
				d(m + ">.layui-tab-title>li").each(function(G) {
					if (d(this).attr("lay-id") == D) {
						E = true;
						return false
					}
				});
				if (!E) {
					if ((g.mTabList.length + 1) >= q.maxTabNum) {
						s.msg("最多打开" + q.maxTabNum + "个选项卡", {
							icon: 2
						});
						g.go(g.mTabPosition);
						return
					}
					b.tabAdd(h, {
						id: D,
						title: '<span class="title">' + (w ? w : "") + "</span>",
						content: '<div lay-id="' + D + '" lay-hash="' + B + '"></div>'
					});
					(B != c) && g.mTabList.push(x);
					(q.cacheTab) && k.putTempData("indexTabs", g.mTabList)
				}
				z = m + '>.layui-tab-content>.layui-tab-item>div[lay-id="' + D + '"]';
				var C = d(z).attr("lay-hash");
				if (B != C) {
					d(z).attr("lay-hash", B);
					E = false;
					for (var y = 0; y < g.mTabList.length; y++) {
						if (g.mTabList[y].menuId == C) {
							g.mTabList[y] = x
						}
					}(q.cacheTab) && k.putTempData("indexTabs", g.mTabList)
				}
				if (!E || l.isRefresh) {
					g.renderView(v, z)
				}
				if (!x.noChange) {
					b.tabChange(h, D)
				}
			} else {
				var F = d(z);
				if (!F || F.length <= 0) {
					var A = '<div class="layui-body-header">';
					A += '      <span class="layui-body-header-title"></span>';
					A += '      <span class="layui-breadcrumb pull-right">';
					A += '         <a href="#' + c + '">首页</a>';
					A += "         <a><cite></cite></a>";
					A += "      </span>";
					A += "   </div>";
					A += '   <div lay-id="' + B + '"></div>';
					d(i).html(A);
					b.render("breadcrumb")
				} else {
					F.attr("lay-id", B)
				}
				if (c != B) {
					g.setTabTitle(w)
				} else {
					g.setTabTitle(undefined)
				}
				k.activeNav(B);
				g.mTabList.splice(0, g.mTabList.length);
				(c != B) && g.mTabList.push(x);
				(q.cacheTab) && k.putTempData("indexTabs", g.mTabList);
				g.mTabPosition = B;
				g.renderView(v, z)
			}(k.getPageWidth() <= 750) && k.flexible(true);
			d(".layui-table-tips-c").trigger("click")
		},
		renderView: function(w, x, y) {
			var v = d(x);
			!y && (y = v.parent());
			k.showLoading(y);
			v.load(w, function() {
				k.renderPerm();
				setTimeout(function() {
					k.removeLoading(y)
				}, 150)
			})
		},
		loadHome: function(y) {
			var A = y.url;
			var v = y.name;
			var z = k.getTempData("indexTabs");
			c = A.substring(1);
			g.regRouter([y]);
			if (q.pageTabs) {
				var w = g.getHashPath(A);
				g.loadView({
					menuId: c,
					menuPath: q.viewPath + w + g.getViewSuffix(w),
					menuName: v,
					noChange: true
				})
			}
			var x = (y.loadSetting == undefined ? true : y.loadSetting);
			if (x) {
				g.loadSettings(z)
			}
			l.init({
				index: c,
				notFound: function(B) {
					q.routerNotFound && q.routerNotFound(B)
				}
			})
		},
		openNewTab: function(v) {
			g.regRouter([v]);
			g.go(v.url.substring(1))
		},
		closeTab: function(w) {
			var v = g.getHashPath("#" + w);
			b.tabDelete(h, v)
		},
		go: function(v) {
			l.go(v)
		},
		getHashPath: function(y) {
			var v = layui.router(y);
			var x = "";
			for (var w = 0; w < v.path.length; w++) {
				x += ("/" + v.path[w])
			}
			return x
		},
		setTabTitle: function(w, v) {
			if (!q.pageTabs) {
				if (w) {
					d(r).addClass("show");
					var x = d(r + ">.layui-body-header-title");
					x.html(w);
					x.next(".layui-breadcrumb").find("cite").last().html(w)
				} else {
					d(r).removeClass("show")
				}
			} else {
				w || (w = "");
				v || (v = g.getHashPath());
				v && d(m + '>.layui-tab-title>li[lay-id="' + v + '"] .title').html(w)
			}
		},
		setTabTitleHtml: function(v) {
			if (!q.pageTabs) {
				if (v) {
					d(r).addClass("show");
					d(r).html(v)
				} else {
					d(r).removeClass("show")
				}
			}
		},
		getViewSuffix: function(w) {
			var v;
			if (typeof q.viewSuffix === "string") {
				v = q.viewSuffix
			} else {
				v = q.viewSuffix(w)
			}
			if (q.version != undefined) {
				if (v.indexOf("?") == -1) {
					v += "?v="
				} else {
					v += "&v="
				}
				if (q.version == true) {
					v += new Date().getTime()
				} else {
					v += q.version
				}
			}
			return v
		},
		loadSettings: function(y) {
			if (q.cacheTab) {
				var z = y;
				if (z) {
					for (var w = 0; w < z.length; w++) {
						if (q.pageTabs) {
							z[w].noChange = true;
							g.loadView(z[w])
						}
					}
				}
			}
			var v = layui.data(q.tableName);
			if (v) {
				var x = v.openFooter;
				if (x != undefined && x == false) {
					d("body.layui-layout-body").addClass("close-footer")
				}
				if (v.navArrow != undefined) {
					d(n + ">.layui-nav-tree").removeClass("arrow2 arrow3");
					v.navArrow && d(n + ">.layui-nav-tree").addClass(v.navArrow)
				}
			}
		}
	};
	var j = layui.data(q.tableName);
	if (j) {
		var p = j.openTab;
		if (p != undefined) {
			q.pageTabs = p
		}
	}
	var f = ".layui-layout-admin .site-mobile-shade";
	if (d(f).length <= 0) {
		d(".layui-layout-admin").append('<div class="site-mobile-shade"></div>')
	}
	d(f).click(function() {
		k.flexible(true)
	});
	if (q.pageTabs && d(m).length <= 0) {
		var e = '<div class="layui-tab" lay-allowClose="true" lay-filter="admin-pagetabs">';
		e += '       <ul class="layui-tab-title"></ul>';
		e += '      <div class="layui-tab-content"></div>';
		e += "   </div>";
		e += '   <div class="layui-icon admin-tabs-control layui-icon-prev" ew-event="leftPage"></div>';
		e += '   <div class="layui-icon admin-tabs-control layui-icon-next" ew-event="rightPage"></div>';
		e += '   <div class="layui-icon admin-tabs-control layui-icon-down">';
		e += '      <ul class="layui-nav admin-tabs-select" lay-filter="admin-pagetabs-nav">';
		e += '         <li class="layui-nav-item" lay-unselect>';
		e += "            <a></a>";
		e += '            <dl class="layui-nav-child layui-anim-fadein">';
		e += '               <dd ew-event="closeThisTabs" lay-unselect><a>关闭当前标签页</a></dd>';
		e += '               <dd ew-event="closeOtherTabs" lay-unselect><a>关闭其它标签页</a></dd>';
		e += '               <dd ew-event="closeAllTabs" lay-unselect><a>关闭全部标签页</a></dd>';
		e += "            </dl>";
		e += "         </li>";
		e += "      </ul>";
		e += "   </div>";
		d(i).html(e);
		b.render("nav")
	}
	b.on("nav(" + o + ")", function(w) {
		var v = d(w);
		if ("true" == d(n + ">.layui-nav-tree").attr("lay-accordion")) {
			if (v.parent().hasClass("layui-nav-itemed") || v.parent().hasClass("layui-this")) {
				d(n + ">.layui-nav .layui-nav-itemed").not(v.parents(".layui-nav-child").parent()).removeClass("layui-nav-itemed");
				v.parent().addClass("layui-nav-itemed")
			}
			v.trigger("mouseenter")
		}
		k.setNavHoverCss(v.parentsUntil(".layui-nav-item").parent().children().eq(0))
	});
	b.on("tab(" + h + ")", function(w) {
		var v = d(this).attr("lay-id");
		var x = d(m + '>.layui-tab-content>.layui-tab-item>div[lay-id="' + v + '"]').attr("lay-hash");
		g.mTabPosition = x;
		k.activeNav(x);
		g.go(x);
		k.resizeTable(0);
		k.rollPage("auto")
	});
	b.on("tabDelete(" + h + ")", function(w) {
		var v = g.mTabList[w.index - 1];
		if (v) {
			g.mTabList.splice(w.index - 1, 1);
			(q.cacheTab) && k.putTempData("indexTabs", g.mTabList)
		}
		if (d(m + ">.layui-tab-title>li.layui-this").length <= 0) {
			d(m + ">.layui-tab-title>li:last").trigger("click")
		}
	});
	d("body").off("click.navMore").on("click.navMore", "[nav-bind]", function() {
		var v = d(this).attr("nav-bind");
		d('ul[lay-filter="' + o + '"]').addClass("layui-hide");
		d('ul[nav-id="' + v + '"]').removeClass("layui-hide");
		if (k.getPageWidth() <= 750) {
			k.flexible(false)
		}
		d(a + ">.layui-nav .layui-nav-item").removeClass("layui-this");
		d(this).parent(".layui-nav-item").addClass("layui-this")
	});
	if (q.openTabCtxMenu && q.pageTabs) {
		d(m + ">.layui-tab-title").off("contextmenu.tab").on("contextmenu.tab", "li", function(w) {
			var v = d(this).attr("lay-id");
			u.show([{
				icon: "layui-icon layui-icon-refresh",
				name: "刷新当前",
				click: function() {
					b.tabChange(h, v);
					k.refresh(g.getHashPath("#" + v))
				}
			}, {
				icon: "layui-icon layui-icon-close-fill ctx-ic-lg",
				name: "关闭当前",
				click: function() {
					k.closeThisTabs(v)
				}
			}, {
				icon: "layui-icon layui-icon-unlink",
				name: "关闭其他",
				click: function() {
					k.closeOtherTabs(v)
				}
			}, {
				icon: "layui-icon layui-icon-close ctx-ic-lg",
				name: "关闭全部",
				click: function() {
					k.closeAllTabs()
				}
			}], w.clientX, w.clientY);
			return false
		})
	}
	t("index", g)
});