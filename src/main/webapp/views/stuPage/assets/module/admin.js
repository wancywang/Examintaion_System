/** EasyWeb spa v3.1.2 date:2019-06-05 License By http://easyweb.vip */

layui.define(["layer", "config", "layRouter"], function(g) {
	var i = layui.jquery;
	var l = layui.layer;
	var c = layui.config;
	var o = layui.layRouter;
	var a = ".layui-layout-admin>.layui-body";
	var m = a + ">.layui-tab";
	var f = ".layui-layout-admin>.layui-side>.layui-side-scroll";
	var k = ".layui-layout-admin>.layui-header";
	var b = "admin-pagetabs";
	var e = "admin-side-nav";
	var d = "theme-admin";
	var n = {
		flexible: function(p) {
			var q = i(".layui-layout-admin").hasClass("admin-nav-mini");
			if (q == !p) {
				return
			}
			if (p) {
				n.hideTableScrollBar();
				i(".layui-layout-admin").removeClass("admin-nav-mini")
			} else {
				i(".layui-layout-admin").addClass("admin-nav-mini")
			}
			n.removeNavHover();
			n.resizeTable(360)
		},
		activeNav: function(p) {
			if (!p) {
				p = location.hash
			}
			if (p && p != "") {
				i(f + ">.layui-nav .layui-nav-item .layui-nav-child dd").removeClass("layui-this");
				i(f + ">.layui-nav .layui-nav-item").removeClass("layui-this");
				var t = i(f + '>.layui-nav a[href="#' + p + '"]');
				if (t && t.length > 0) {
					if (i(f + ">.layui-nav").attr("lay-accordion") == "true") {
						i(f + ">.layui-nav .layui-nav-itemed").removeClass("layui-nav-itemed")
					}
					t.parent().addClass("layui-this");
					t.parent("dd").parents(".layui-nav-child").parent().addClass("layui-nav-itemed");
					i('ul[lay-filter="' + e + '"]').addClass("layui-hide");
					var r = t.parents(".layui-nav");
					r.removeClass("layui-hide");
					i(k + ">.layui-nav>.layui-nav-item").removeClass("layui-this");
					i(k + '>.layui-nav>.layui-nav-item>a[nav-bind="' + r.attr("nav-id") + '"]').parent().addClass("layui-this");
					var q = t.offset().top + t.outerHeight() + 30 - n.getPageHeight();
					var s = 50 + 65 - t.offset().top;
					if (q > 0) {
						i(f).animate({
							"scrollTop": i(f).scrollTop() + q
						}, 100)
					} else {
						if (s > 0) {
							i(f).animate({
								"scrollTop": i(f).scrollTop() - s
							}, 100)
						}
					}
				} else {}
			} else {
				console.warn("active url is null")
			}
		},
		popupRight: function(p) {
			if (p.title == undefined) {
				p.title = false;
				p.closeBtn = false
			}
			if (p.anim == undefined) {
				p.anim = 2
			}
			if (p.fixed == undefined) {
				p.fixed = true
			}
			p.isOutAnim = false;
			p.offset = "r";
			p.shadeClose = true;
			p.area = "336px";
			p.skin = "layui-layer-adminRight";
			p.move = false;
			return n.open(p)
		},
		open: function(r) {
			if (!r.area) {
				r.area = (r.type == 2) ? ["360px", "300px"] : "360px"
			}
			if (!r.skin) {
				r.skin = "layui-layer-admin"
			}
			if (!r.offset) {
				r.offset = "35px"
			}
			if (r.fixed == undefined) {
				r.fixed = false
			}
			r.resize = r.resize != undefined ? r.resize : false;
			r.shade = r.shade != undefined ? r.shade : 0.1;
			var p = r.end;
			r.end = function() {
				l.closeAll("tips");
				p && p()
			};
			if (r.url) {
				(r.type == undefined) && (r.type = 1);
				var q = r.success;
				r.success = function(s, t) {
					var u = r.url;
					if (c.version != undefined) {
						if (u.indexOf("?") == -1) {
							u += "?v="
						} else {
							u += "&v="
						}
						if (c.version == true) {
							u += new Date().getTime()
						} else {
							u += c.version
						}
					}
					n.showLoading(s, 2);
					i(s).children(".layui-layer-content").load(u, function() {
						q ? q(s, t) : "";
						n.removeLoading(s, false)
					})
				}
			}
			return l.open(r)
		},
		req: function(p, q, r, s) {
			if (c.reqPutToPost != false) {
				if ("put" == s.toLowerCase()) {
					s = "POST";
					q._method = "PUT"
				} else {
					if ("delete" == s.toLowerCase()) {
						s = "POST";
						q._method = "DELETE"
					}
				}
			}
			n.ajax({
				url: c.base_server + p,
				data: q,
				type: s,
				dataType: "json",
				success: r
			})
		},
		ajax: function(q) {
			var p = q.success;
			q.success = function(r, s, u) {
				var t;
				if ("json" == q.dataType.toLowerCase()) {
					t = r
				} else {
					t = n.parseJSON(r)
				}
				t && (t = r);
				if (c.ajaxSuccessBefore(t, q.url) == false) {
					return
				}
				p(r, s, u)
			};
			q.error = function(r) {
				q.success({
					code: r.status,
					msg: r.statusText
				})
			};
			q.beforeSend = function(t) {
				var s = c.getAjaxHeaders(q.url);
				for (var r = 0; r < s.length; r++) {
					t.setRequestHeader(s[r].name, s[r].value)
				}
			};
			i.ajax(q)
		},
		parseJSON: function(r) {
			if (typeof r == "string") {
				try {
					var q = JSON.parse(r);
					if (typeof q == "object" && q) {
						return q
					}
				} catch (p) {}
			}
		},
		showLoading: function(s, r, q) {
			var p = ['<div class="ball-loader"><span></span><span></span><span></span><span></span></div>', '<div class="rubik-loader"></div>'];
			if (!s) {
				s = "body"
			}
			if (r == undefined) {
				r = 1
			}
			i(s).addClass("page-no-scroll");
			var t = i(s).children(".page-loading");
			if (t.length <= 0) {
				i(s).append('<div class="page-loading">' + p[r - 1] + "</div>");
				t = i(s).children(".page-loading")
			}
			q && t.css("background-color", "rgba(255,255,255," + q + ")");
			t.show()
		},
		removeLoading: function(q, s, p) {
			if (!q) {
				q = "body"
			}
			if (s == undefined) {
				s = true
			}
			var r = i(q).children(".page-loading");
			if (p) {
				r.remove()
			} else {
				s ? r.fadeOut() : r.hide()
			}
			i(q).removeClass("page-no-scroll")
		},
		putTempData: function(q, r) {
			var p = c.tableName + "_tempData";
			if (r != undefined && r != null) {
				layui.sessionData(p, {
					key: q,
					value: r
				})
			} else {
				layui.sessionData(p, {
					key: q,
					remove: true
				})
			}
		},
		getTempData: function(q) {
			var p = c.tableName + "_tempData";
			var r = layui.sessionData(p);
			if (r) {
				return r[q]
			} else {
				return false
			}
		},
		rollPage: function(s) {
			var q = i(m + ">.layui-tab-title");
			var r = q.scrollLeft();
			if ("left" === s) {
				q.animate({
					"scrollLeft": r - 120
				}, 100)
			} else {
				if ("auto" === s) {
					var p = 0;
					q.children("li").each(function() {
						if (i(this).hasClass("layui-this")) {
							return false
						} else {
							p += i(this).outerWidth()
						}
					});
					q.animate({
						"scrollLeft": p - 120
					}, 100)
				} else {
					q.animate({
						"scrollLeft": r + 120
					}, 100)
				}
			}
		},
		refresh: function(p) {
			o.refresh(p)
		},
		closeThisTabs: function(p) {
			n.closeTabOperNav();
			var q = i(m + ">.layui-tab-title");
			if (!p) {
				if (q.find("li").first().hasClass("layui-this")) {
					l.msg("主页不能关闭", {
						icon: 2
					});
					return
				}
				q.find("li.layui-this").find(".layui-tab-close").trigger("click")
			} else {
				if (p == q.find("li").first().attr("lay-id")) {
					l.msg("主页不能关闭", {
						icon: 2
					});
					return
				}
				q.find('li[lay-id="' + p + '"]').find(".layui-tab-close").trigger("click")
			}
		},
		closeOtherTabs: function(p) {
			if (!p) {
				i(m + ">.layui-tab-title li:gt(0):not(.layui-this)").find(".layui-tab-close").trigger("click")
			} else {
				i(m + ">.layui-tab-title li:gt(0)").each(function() {
					if (p != i(this).attr("lay-id")) {
						i(this).find(".layui-tab-close").trigger("click")
					}
				})
			}
			n.closeTabOperNav()
		},
		closeAllTabs: function() {
			i(m + ">.layui-tab-title li:gt(0)").find(".layui-tab-close").trigger("click");
			i(m + ">.layui-tab-title li:eq(0)").trigger("click");
			n.closeTabOperNav()
		},
		closeTabOperNav: function() {
			i(".layui-icon-down .layui-nav .layui-nav-child").removeClass("layui-show")
		},
		changeTheme: function(u) {
			if (u) {
				layui.data(c.tableName, {
					key: "theme",
					value: u
				});
				if (d == u) {
					u = undefined
				}
			} else {
				layui.data(c.tableName, {
					key: "theme",
					remove: true
				})
			}
			n.removeTheme(top);
			!u || top.layui.link(n.getThemeDir() + u + n.getCssSuffix(), u);
			var v = top.window.frames;
			for (var r = 0; r < v.length; r++) {
				var t = v[r];
				n.removeTheme(t);
				if (u && t.layui) {
					t.layui.link(n.getThemeDir() + u + n.getCssSuffix(), u)
				}
				var s = t.frames;
				for (var q = 0; q < s.length; q++) {
					var p = s[q];
					n.removeTheme(p);
					if (u && p.layui) {
						p.layui.link(n.getThemeDir() + u + n.getCssSuffix(), u)
					}
				}
			}
		},
		removeTheme: function(p) {
			if (!p) {
				p = window
			}
			if (p.layui) {
				var q = "layuicss-theme";
				p.layui.jquery('link[id^="' + q + '"]').remove()
			}
		},
		getThemeDir: function() {
			return layui.cache.base + "theme/"
		},
		closeThisDialog: function() {
			parent.layer.close(parent.layer.getFrameIndex(window.name))
		},
		closeDialog: function(p) {
			var q = i(p).parents(".layui-layer").attr("id").substring(11);
			l.close(q)
		},
		iframeAuto: function() {
			parent.layer.iframeAuto(parent.layer.getFrameIndex(window.name))
		},
		getPageHeight: function() {
			return document.documentElement.clientHeight || document.body.clientHeight
		},
		getPageWidth: function() {
			return document.documentElement.clientWidth || document.body.clientWidth
		},
		removeNavHover: function() {
			i(".admin-nav-hover>.layui-nav-child").css({
				"top": "auto",
				"max-height": "none",
				"overflow": "auto"
			});
			i(".admin-nav-hover").removeClass("admin-nav-hover")
		},
		setNavHoverCss: function(r) {
			var p = i(".admin-nav-hover>.layui-nav-child");
			if (r && p.length > 0 && r.offset()) {
				var t = (r.offset().top + p.outerHeight()) > window.innerHeight;
				if (t) {
					var q = r.offset().top - p.outerHeight() + r.outerHeight();
					if (q < 50) {
						var s = n.getPageHeight();
						if (r.offset().top < s / 2) {
							p.css({
								"top": "50px",
								"max-height": s - 50 + "px",
								"overflow": "auto"
							})
						} else {
							p.css({
								"top": r.offset().top,
								"max-height": s - r.offset().top,
								"overflow": "auto"
							})
						}
					} else {
						p.css("top", q)
					}
				} else {
					p.css("top", r.offset().top)
				}
				j = true
			}
		},
		getCssSuffix: function() {
			var p = ".css";
			if (c.version != undefined) {
				p += "?v=";
				if (c.version == true) {
					p += new Date().getTime()
				} else {
					p += c.version
				}
			}
			return p
		},
		hideTableScrollBar: function(q) {
			if (n.getPageWidth() > 750) {
				if (window.hsbTimer) {
					clearTimeout(hsbTimer)
				}
				var p = c.pageTabs ? i(m + ">.layui-tab-content>.layui-tab-item.layui-show") : i(a);
				p.find(".layui-table-body.layui-table-main").addClass("no-scrollbar");
				window.hsbTimer = setTimeout(function() {
					p.find(".layui-table-body.layui-table-main").removeClass("no-scrollbar")
				}, q == undefined ? 500 : q)
			}
		},
		modelForm: function(q, u, p) {
			var t = i(q);
			t.addClass("layui-form");
			if (p) {
				t.attr("id", p);
				t.attr("lay-filter", p)
			}
			var s = t.find(".layui-layer-btn .layui-layer-btn0");
			s.attr("lay-submit", "");
			s.attr("lay-filter", u);
			var r = t.children(".layui-layer-content");
			r.find('[ew-event="closePageDialog"]').remove();
			r.find("[lay-submit]").remove()
		},
		btnLoading: function(q, r, s) {
			if (r != undefined && (typeof r == "boolean")) {
				s = r;
				r = undefined
			}(s == undefined) && (s = true);
			var p = i(q);
			if (s) {
				r && p.html(r);
				p.find(".layui-icon").addClass("layui-hide");
				p.addClass("icon-btn");
				p.prepend('<i class="layui-icon layui-icon-loading layui-anim layui-anim-rotate layui-anim-loop ew-btn-loading"></i>');
				p.prop("disabled", "disabled")
			} else {
				p.find(".ew-btn-loading").remove();
				p.removeProp("disabled", "disabled");
				if (p.find(".layui-icon.layui-hide").length <= 0) {
					p.removeClass("icon-btn")
				}
				p.find(".layui-icon").removeClass("layui-hide");
				r && p.html(r)
			}
		},
		openSideAutoExpand: function() {
			i(".layui-layout-admin>.layui-side").off("mouseenter.openSideAutoExpand").on("mouseenter.openSideAutoExpand", function() {
				if (i(this).parent().hasClass("admin-nav-mini")) {
					n.flexible(true);
					i(this).addClass("side-mini-hover")
				}
			});
			i(".layui-layout-admin>.layui-side").off("mouseleave.openSideAutoExpand").on("mouseleave.openSideAutoExpand", function() {
				if (i(this).hasClass("side-mini-hover")) {
					n.flexible(false);
					i(this).removeClass("side-mini-hover")
				}
			})
		},
		openCellAutoExpand: function() {
			i("body").off("mouseenter.openCellAutoExpand").on("mouseenter.openCellAutoExpand", ".layui-table-view td", function() {
				i(this).find(".layui-table-grid-down").trigger("click")
			});
			i("body").off("mouseleave.openCellAutoExpand").on("mouseleave.openCellAutoExpand", ".layui-table-tips>.layui-layer-content", function() {
				i(".layui-table-tips-c").trigger("click")
			})
		},
		hasPerm: function(r) {
			var p = c.getUserAuths();
			if (p) {
				for (var q = 0; q < p.length; q++) {
					if (r == p[q]) {
						return true
					}
				}
			}
			return false
		},
		renderPerm: function() {
			i("[perm-show]").each(function(p, r) {
				var q = i(this).attr("perm-show");
				if (!n.hasPerm(q)) {
					i(this).remove()
				}
			})
		},
		resizeTable: function(p) {
			setTimeout(function() {
				var q = c.pageTabs ? i(m + ">.layui-tab-content>.layui-tab-item.layui-show") : i(a);
				q.find(".layui-table-view").each(function() {
					var r = i(this).attr("lay-id");
					layui.table && layui.table.resize(r)
				})
			}, p == undefined ? 0 : p)
		}
	};
	n.events = {
		flexible: function(q) {
			var p = i(".layui-layout-admin").hasClass("admin-nav-mini");
			n.flexible(p)
		},
		refresh: function() {
			n.refresh()
		},
		back: function() {
			history.back()
		},
		theme: function() {
			var p = i(this).attr("data-url");
			n.popupRight({
				id: "layer-theme",
				url: p ? p : "components/tpl/theme.html"
			})
		},
		note: function() {
			var p = i(this).attr("data-url");
			n.popupRight({
				id: "layer-note",
				url: p ? p : "components/tpl/note.html"
			})
		},
		message: function() {
			var p = i(this).attr("data-url");
			n.popupRight({
				id: "layer-notice",
				url: p ? p : "components/tpl/message.html"
			})
		},
		psw: function() {
			var p = i(this).attr("data-url");
			n.open({
				id: "pswForm",
				title: "修改密码",
				shade: 0,
				url: p ? p : "components/tpl/password.html"
			})
		},
		logout: function() {
			var p = i(this).attr("data-url");
			l.confirm("确定要退出登录吗？", {
				title: "温馨提示",
				skin: "layui-layer-admin"
			}, function() {
				c.removeToken();
				p ? location.replace(p) : location.reload()
			})
		},
		fullScreen: function(v) {
			var x = "layui-icon-screen-full",
				r = "layui-icon-screen-restore";
			var p = i(this).find("i");
			var u = document.fullscreenElement || document.msFullscreenElement || document.mozFullScreenElement || document.webkitFullscreenElement || false;
			if (u) {
				var t = document.exitFullscreen || document.webkitExitFullscreen || document.mozCancelFullScreen || document.msExitFullscreen;
				if (t) {
					t.call(document)
				} else {
					if (window.ActiveXObject) {
						var w = new ActiveXObject("WScript.Shell");
						w && w.SendKeys("{F11}")
					}
				}
				p.addClass(x).removeClass(r)
			} else {
				var q = document.documentElement;
				var s = q.requestFullscreen || q.webkitRequestFullscreen || q.mozRequestFullScreen || q.msRequestFullscreen;
				if (s) {
					s.call(q)
				} else {
					if (window.ActiveXObject) {
						var w = new ActiveXObject("WScript.Shell");
						w && w.SendKeys("{F11}")
					}
				}
				p.addClass(r).removeClass(x)
			}
		},
		leftPage: function() {
			n.rollPage("left")
		},
		rightPage: function() {
			n.rollPage()
		},
		closeThisTabs: function() {
			n.closeThisTabs()
		},
		closeOtherTabs: function() {
			n.closeOtherTabs()
		},
		closeAllTabs: function() {
			n.closeAllTabs()
		},
		closeDialog: function() {
			n.closeDialog(this)
		},
		closeIframeDialog: function() {
			n.closeThisDialog()
		}
	};
	i(document).on("click", "*[ew-event]", function() {
		var p = i(this).attr("ew-event");
		var q = n.events[p];
		q && q.call(this, i(this))
	});
	i(document).on("mouseenter", "*[lay-tips]", function() {
		var p = i(this).attr("lay-tips");
		var q = i(this).attr("lay-direction");
		var r = i(this).attr("lay-bg");
		l.tips(p, this, {
			tips: [q || 3, r || "#333333"],
			time: -1
		})
	}).on("mouseleave", "*[lay-tips]", function() {
		l.closeAll("tips")
	});
	var j = false;
	i(document).on("mouseenter", ".layui-layout-admin.admin-nav-mini .layui-side .layui-nav .layui-nav-item>a", function() {
		if (n.getPageWidth() > 750) {
			var r = i(this);
			i(".admin-nav-hover>.layui-nav-child").css("top", "auto");
			i(".admin-nav-hover").removeClass("admin-nav-hover");
			r.parent().addClass("admin-nav-hover");
			var p = i(".admin-nav-hover>.layui-nav-child");
			if (p.length > 0) {
				n.setNavHoverCss(r)
			} else {
				var q = r.find("cite").text();
				l.tips(q, r, {
					tips: [2, "#333333"],
					time: -1
				})
			}
		}
	}).on("mouseleave", ".layui-layout-admin.admin-nav-mini .layui-side .layui-nav .layui-nav-item>a", function() {
		l.closeAll("tips")
	});
	i(document).on("mouseleave", ".layui-layout-admin.admin-nav-mini .layui-side", function() {
		j = false;
		setTimeout(function() {
			if (!j) {
				n.removeNavHover()
			}
		}, 500)
	});
	i(document).on("mouseenter", ".layui-layout-admin.admin-nav-mini .layui-side .layui-nav .layui-nav-item.admin-nav-hover .layui-nav-child", function() {
		j = true
	});
	var h = layui.data(c.tableName);
	if (h && h.theme) {
		(h.theme == d) || layui.link(n.getThemeDir() + h.theme + n.getCssSuffix(), h.theme)
	} else {
		if (d != c.defaultTheme) {
			layui.link(n.getThemeDir() + c.defaultTheme + n.getCssSuffix(), c.defaultTheme)
		}
	}
	n.chooseLocation = function(u) {
		var q = u.title;
		var y = u.onSelect;
		var s = u.needCity;
		var z = u.center;
		var C = u.defaultZoom;
		var v = u.pointZoom;
		var x = u.keywords;
		var B = u.pageSize;
		var t = u.mapJsUrl;
		(q == undefined) && (q = "选择位置");
		(C == undefined) && (C = 11);
		(v == undefined) && (v = 17);
		(x == undefined) && (x = "");
		(B == undefined) && (B = 30);
		(t == undefined) && (t = "https://webapi.amap.com/maps?v=1.4.14&key=006d995d433058322319fa797f2876f5");
		var D = false,
			A;
		var w = function(F, E) {
				AMap.service(["AMap.PlaceSearch"], function() {
					var H = new AMap.PlaceSearch({
						type: "",
						pageSize: B,
						pageIndex: 1
					});
					var G = [E, F];
					H.searchNearBy(x, G, 1000, function(J, I) {
						if (J == "complete") {
							var M = I.poiList.pois;
							var N = "";
							for (var L = 0; L < M.length; L++) {
								var K = M[L];
								if (K.location != undefined) {
									N += '<div data-lng="' + K.location.lng + '" data-lat="' + K.location.lat + '" class="ew-map-select-search-list-item">';
									N += '     <div class="ew-map-select-search-list-item-title">' + K.name + "</div>";
									N += '     <div class="ew-map-select-search-list-item-address">' + K.address + "</div>";
									N += '     <div class="ew-map-select-search-list-item-icon-ok layui-hide"><i class="layui-icon layui-icon-ok-circle"></i></div>';
									N += "</div>"
								}
							}
							i("#ew-map-select-pois").html(N)
						}
					})
				})
			};
		var p = function() {
				var E = {
					resizeEnable: true,
					zoom: C
				};
				z && (E.center = z);
				var F = new AMap.Map("ew-map-select-map", E);
				F.on("complete", function() {
					var G = F.getCenter();
					w(G.lat, G.lng)
				});
				F.on("moveend", function() {
					if (D) {
						D = false
					} else {
						i("#ew-map-select-tips").addClass("layui-hide");
						i("#ew-map-select-center-img").removeClass("bounceInDown");
						setTimeout(function() {
							i("#ew-map-select-center-img").addClass("bounceInDown")
						});
						var G = F.getCenter();
						w(G.lat, G.lng)
					}
				});
				i("#ew-map-select-pois").off("click").on("click", ".ew-map-select-search-list-item", function() {
					i("#ew-map-select-tips").addClass("layui-hide");
					i("#ew-map-select-pois .ew-map-select-search-list-item-icon-ok").addClass("layui-hide");
					i(this).find(".ew-map-select-search-list-item-icon-ok").removeClass("layui-hide");
					i("#ew-map-select-center-img").removeClass("bounceInDown");
					setTimeout(function() {
						i("#ew-map-select-center-img").addClass("bounceInDown")
					});
					var I = i(this).data("lng");
					var J = i(this).data("lat");
					var H = i(this).find(".ew-map-select-search-list-item-title").text();
					var G = i(this).find(".ew-map-select-search-list-item-address").text();
					A = {
						name: H,
						address: G,
						lat: J,
						lng: I
					};
					D = true;
					F.setZoomAndCenter(v, [I, J])
				});
				i("#ew-map-select-btn-ok").click(function() {
					if (A == undefined) {
						l.msg("请点击位置列表选择", {
							icon: 2,
							anim: 6
						})
					} else {
						if (y) {
							if (s) {
								var G = l.load(2);
								F.setCenter([A.lng, A.lat]);
								F.getCity(function(H) {
									l.close(G);
									A.city = H;
									n.closeDialog("#ew-map-select-btn-ok");
									y(A)
								})
							} else {
								n.closeDialog("#ew-map-select-btn-ok");
								y(A)
							}
						} else {
							n.closeDialog("#ew-map-select-btn-ok")
						}
					}
				});
				i("#ew-map-select-input-search").off("input").on("input", function() {
					var G = i(this).val();
					if (!G) {
						i("#ew-map-select-tips").html("");
						i("#ew-map-select-tips").addClass("layui-hide")
					}
					AMap.plugin("AMap.Autocomplete", function() {
						var H = new AMap.Autocomplete({
							city: "全国"
						});
						H.search(G, function(K, J) {
							if (J.tips) {
								var I = J.tips;
								var M = "";
								for (var L = 0; L < I.length; L++) {
									var N = I[L];
									if (N.location != undefined) {
										M += '<div data-lng="' + N.location.lng + '" data-lat="' + N.location.lat + '" class="ew-map-select-search-list-item">';
										M += '     <div class="ew-map-select-search-list-item-icon-search"><i class="layui-icon layui-icon-search"></i></div>';
										M += '     <div class="ew-map-select-search-list-item-title">' + N.name + "</div>";
										M += '     <div class="ew-map-select-search-list-item-address">' + N.address + "</div>";
										M += "</div>"
									}
								}
								i("#ew-map-select-tips").html(M);
								if (I.length == 0) {
									i("#ew-map-select-tips").addClass("layui-hide")
								} else {
									i("#ew-map-select-tips").removeClass("layui-hide")
								}
							} else {
								i("#ew-map-select-tips").html("");
								i("#ew-map-select-tips").addClass("layui-hide")
							}
						})
					})
				});
				i("#ew-map-select-input-search").off("blur").on("blur", function() {
					var G = i(this).val();
					if (!G) {
						i("#ew-map-select-tips").html("");
						i("#ew-map-select-tips").addClass("layui-hide")
					}
				});
				i("#ew-map-select-input-search").off("focus").on("focus", function() {
					var G = i(this).val();
					if (G) {
						i("#ew-map-select-tips").removeClass("layui-hide")
					}
				});
				i("#ew-map-select-tips").off("click").on("click", ".ew-map-select-search-list-item", function() {
					i("#ew-map-select-tips").addClass("layui-hide");
					var G = i(this).data("lng");
					var H = i(this).data("lat");
					A = undefined;
					F.setZoomAndCenter(v, [G, H])
				})
			};
		var r = '<div class="ew-map-select-tool" style="position: relative;">';
		r += '        搜索：<input id="ew-map-select-input-search" class="layui-input icon-search inline-block" style="width: 190px;" placeholder="输入关键字搜索" autocomplete="off" />';
		r += '        <button id="ew-map-select-btn-ok" class="layui-btn icon-btn pull-right" type="button"><i class="layui-icon">&#xe605;</i>确定</button>';
		r += '        <div id="ew-map-select-tips" class="ew-map-select-search-list layui-hide">';
		r += "        </div>";
		r += "   </div>";
		r += '   <div class="layui-row ew-map-select">';
		r += '        <div class="layui-col-sm7 ew-map-select-map-group" style="position: relative;">';
		r += '             <div id="ew-map-select-map"></div>';
		r += '             <i id="ew-map-select-center-img2" class="layui-icon layui-icon-add-1"></i>';
		r += '             <img id="ew-map-select-center-img" src="https://3gimg.qq.com/lightmap/components/locationPicker2/image/marker.png"/>';
		r += "        </div>";
		r += '        <div id="ew-map-select-pois" class="layui-col-sm5 ew-map-select-search-list">';
		r += "        </div>";
		r += "   </div>";
		n.open({
			id: "ew-map-select",
			type: 1,
			title: q,
			area: "750px",
			content: r,
			success: function(E, F) {
				i(E).children(".layui-layer-content").css("overflow", "visible");
				n.showLoading(E);
				if (undefined == window.AMap) {
					i.getScript(t, function() {
						p();
						n.removeLoading(E)
					})
				} else {
					p();
					n.removeLoading(E)
				}
			}
		})
	};
	n.cropImg = function(s) {
		var q = "image/jpeg";
		var x = s.aspectRatio;
		var y = s.imgSrc;
		var v = s.imgType;
		var t = s.onCrop;
		var u = s.limitSize;
		var w = s.acceptMime;
		var r = s.exts;
		var p = s.title;
		(x == undefined) && (x = 1 / 1);
		(p == undefined) && (p = "裁剪图片");
		v && (q = v);
		layui.use(["cropper", "upload"], function() {
			var z = layui.upload;

			function A() {
				var D = i("#ew-crop-img");
				var E = {
					elem: "#ew-crop-img-upload",
					auto: false,
					drag: false,
					choose: function(F) {
						F.preview(function(H, I, G) {
							q = I.type;
							if (!y) {
								y = G;
								i("#ew-crop-img").attr("src", G);
								A()
							} else {
								D.cropper("destroy").attr("src", G).cropper(C)
							}
						})
					}
				};
				(u != undefined) && (E.size = u);
				(w != undefined) && (E.acceptMime = w);
				(r != undefined) && (E.exts = r);
				z.render(E);
				if (!y) {
					i("#ew-crop-img-upload").trigger("click");
					return
				}
				var C = {
					aspectRatio: x,
					preview: "#ew-crop-img-preview"
				};
				D.cropper(C);
				i(".ew-crop-tool").on("click", "[data-method]", function() {
					var G = D.data("cropper");
					var H = i(this).data(),
						I, F;
					if (!G || !H.method) {
						return
					}
					H = i.extend({}, H);
					I = G.cropped;
					switch (H.method) {
					case "rotate":
						if (I && C.viewMode > 0) {
							D.cropper("clear")
						}
						break;
					case "getCroppedCanvas":
						if (q === "image/jpeg") {
							if (!H.option) {
								H.option = {}
							}
							H.option.fillColor = "#fff"
						}
						break
					}
					F = D.cropper(H.method, H.option, H.secondOption);
					switch (H.method) {
					case "rotate":
						if (I && C.viewMode > 0) {
							D.cropper("crop")
						}
						break;
					case "scaleX":
					case "scaleY":
						i(this).data("option", -H.option);
						break;
					case "getCroppedCanvas":
						if (F) {
							t && t(F.toDataURL(q));
							n.closeDialog("#ew-crop-img")
						} else {
							l.msg("裁剪失败", {
								icon: 2,
								anim: 6
							})
						}
						break
					}
				})
			}
			var B = '<div class="layui-row">';
			B += '        <div class="layui-col-sm8" style="min-height: 9rem;">';
			B += '             <img id="ew-crop-img" src="' + (y ? y : "") + '" style="max-width:100%;" />';
			B += "        </div>";
			B += '        <div class="layui-col-sm4 layui-hide-xs" style="padding: 0 20px;text-align: center;">';
			B += '             <div id="ew-crop-img-preview" style="width: 100%;height: 9rem;overflow: hidden;display: inline-block;border: 1px solid #dddddd;"></div>';
			B += "        </div>";
			B += "   </div>";
			B += '   <div class="text-center ew-crop-tool" style="padding: 15px 10px 5px 0;">';
			B += '        <div class="layui-btn-group" style="margin-bottom: 10px;margin-left: 10px;">';
			B += '             <button title="放大" data-method="zoom" data-option="0.1" class="layui-btn icon-btn" type="button"><i class="layui-icon layui-icon-add-1"></i></button>';
			B += '             <button title="缩小" data-method="zoom" data-option="-0.1" class="layui-btn icon-btn" type="button"><span style="display: inline-block;width: 12px;height: 2.5px;background: rgba(255, 255, 255, 0.9);vertical-align: middle;margin: 0 4px;"></span></button>';
			B += "        </div>";
			B += '        <div class="layui-btn-group layui-hide-xs" style="margin-bottom: 10px;">';
			B += '             <button title="向左旋转" data-method="rotate" data-option="-45" class="layui-btn icon-btn" type="button"><i class="layui-icon layui-icon-refresh-1" style="transform: rotateY(180deg) rotate(40deg);display: inline-block;"></i></button>';
			B += '             <button title="向右旋转" data-method="rotate" data-option="45" class="layui-btn icon-btn" type="button"><i class="layui-icon layui-icon-refresh-1" style="transform: rotate(30deg);display: inline-block;"></i></button>';
			B += "        </div>";
			B += '        <div class="layui-btn-group" style="margin-bottom: 10px;">';
			B += '             <button title="左移" data-method="move" data-option="-10" data-second-option="0" class="layui-btn icon-btn" type="button"><i class="layui-icon layui-icon-left"></i></button>';
			B += '             <button title="右移" data-method="move" data-option="10" data-second-option="0" class="layui-btn icon-btn" type="button"><i class="layui-icon layui-icon-right"></i></button>';
			B += '             <button title="上移" data-method="move" data-option="0" data-second-option="-10" class="layui-btn icon-btn" type="button"><i class="layui-icon layui-icon-up"></i></button>';
			B += '             <button title="下移" data-method="move" data-option="0" data-second-option="10" class="layui-btn icon-btn" type="button"><i class="layui-icon layui-icon-down"></i></button>';
			B += "        </div>";
			B += '        <div class="layui-btn-group" style="margin-bottom: 10px;">';
			B += '             <button title="左右翻转" data-method="scaleX" data-option="-1" class="layui-btn icon-btn" type="button" style="position: relative;width: 41px;"><i class="layui-icon layui-icon-triangle-r" style="position: absolute;left: 9px;top: 0;transform: rotateY(180deg);font-size: 16px;"></i><i class="layui-icon layui-icon-triangle-r" style="position: absolute; right: 3px; top: 0;font-size: 16px;"></i></button>';
			B += '             <button title="上下翻转" data-method="scaleY" data-option="-1" class="layui-btn icon-btn" type="button" style="position: relative;width: 41px;"><i class="layui-icon layui-icon-triangle-d" style="position: absolute;left: 11px;top: 6px;transform: rotateX(180deg);line-height: normal;font-size: 16px;"></i><i class="layui-icon layui-icon-triangle-d" style="position: absolute; left: 11px; top: 14px;line-height: normal;font-size: 16px;"></i></button>';
			B += "        </div>";
			B += '        <div class="layui-btn-group" style="margin-bottom: 10px;">';
			B += '             <button title="重新开始" data-method="reset" class="layui-btn icon-btn" type="button"><i class="layui-icon layui-icon-refresh"></i></button>';
			B += '             <button title="选择图片" id="ew-crop-img-upload" class="layui-btn icon-btn" type="button"><i class="layui-icon layui-icon-upload-drag"></i></button>';
			B += "        </div>";
			B += '        <button data-method="getCroppedCanvas" data-option="{ &quot;maxWidth&quot;: 4096, &quot;maxHeight&quot;: 4096 }" class="layui-btn icon-btn" type="button" style="margin-left: 10px;margin-bottom: 10px;"><i class="layui-icon">&#xe605;</i>完成</button>';
			B += "   </div>";
			n.open({
				title: p,
				area: "665px",
				type: 1,
				content: B,
				success: function(C, D) {
					i(C).children(".layui-layer-content").css("overflow", "visible");
					A()
				}
			})
		})
	};
	g("admin", n)
});