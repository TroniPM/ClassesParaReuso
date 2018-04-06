/**
 * TODO list:
 * 1- getHtmlSourceAsHtml();
 * 2- getHtmlSourceAsText();
 */
package com.tronipm.java.interfacehtml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLObject {
	private String tag;
	private int line_start, line_end;
	private String str_start, str_end;
	private ArrayList<HTMLObject> childrens = new ArrayList<>();
	private Map<String, String> attributes = new HashMap<String, String>();
	private static String TAG_START = "<", TAG_END = ">", TAG_FINISH = "</", TAG_FINISH_INLINE = "/>", CRLF = "\r\n", JAVA_CRLF = "\n", HTML_COMMENT_START = "<!--", HTML_COMMENT_END = "-->";
	private boolean hasParent = false;
	private boolean inlineTag = false;
	private String htmlSource = "";
	private ArrayList<HTMLObject> allObjects = new ArrayList<>();

	public String getHtmlSourceAsHtml() {
		return htmlSource;
	}

	public String getHtmlSourceAsText() {
		//TODO Remover todas as tags sem remover que tem dentro delas <*>...........</*>
		try {
			throw new Exception("Após concluir o método 'getHtmlSourceAsHtml()', chamá-lo e remover as tags, sem remover o conteúdo <TAG>CONTEUDO</TAG>");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		String txt = "<ul class='wp-submenu wp-submenu-wrap'><li class='wp-submenu-head'>Painel</li><li class=\"wp-first-item current\"><a href='index.php' class=\"wp-first-item current\">Início</a></li><li><a href='update-core.php'>Atualizações <span class='update-plugins count-8' title='1 Atualização do WordPress, 3 atualizações de plugin, 4 atualização de temas'><span class='update-count'>8</span></span></a></li></ul>";
		txt = "<!DOCTYPE html><!--[if IE 8]><html xmlns=\"http://www.w3.org/1999/xhtml\" class=\"ie8 wp-toolbar\"  lang=\"pt-BR\"><![endif]--><!--[if !(IE 8) ]><!--><html xmlns=\"http://www.w3.org/1999/xhtml\" class=\"wp-toolbar\"  lang=\"pt-BR\"><!--<![endif]--><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /><title>Posts &lsaquo; JP Contábil &amp; Filhos &#8212; WordPress</title><script type=\"text/javascript\">addLoadEvent = function(func){if(typeof jQuery!=\"undefined\")jQuery(document).ready(func);else if(typeof wpOnload!='function'){wpOnload=func;}else{var oldonload=wpOnload;wpOnload=function(){oldonload();func();}}};var ajaxurl = '/wp/wp-admin/admin-ajax.php',	pagenow = 'edit-post',	typenow = 'post',	adminpage = 'edit-php',	thousandsSeparator = '.',	decimalPoint = ',',	isRtl = 0;</script><meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0\"><style type=\"text/css\">img.wp-smiley,img.emoji {	display: inline !important;	border: none !important;	box-shadow: none !important;	height: 1em !important;	width: 1em !important;	margin: 0 .07em !important;	vertical-align: -0.1em !important;	background: none !important;	padding: 0 !important;}</style><link rel='stylesheet' href='http://jpcontabil.com/wp/wp-admin/load-styles.php?c=1&amp;dir=ltr&amp;load=dashicons,admin-bar,wp-admin,buttons,wp-auth-check,wp-color-picker&amp;ver=4.2.20' type='text/css' media='all' /><link rel='stylesheet' id='open-sans-css'  href='//fonts.googleapis.com/css?family=Open+Sans%3A300italic%2C400italic%2C600italic%2C300%2C400%2C600&#038;subset=latin%2Clatin-ext&#038;ver=4.2.20' type='text/css' media='all' /><!--[if lte IE 7]><link rel='stylesheet' id='ie-css'  href='http://jpcontabil.com/wp/wp-admin/css/ie.min.css?ver=4.2.20' type='text/css' media='all' /><![endif]--><link rel='stylesheet' id='slideshow-jquery-image-gallery-backend-style-css'  href='http://jpcontabil.com/wp/wp-content/plugins/slideshow-jquery-image-gallery/css/all.backend.css?ver=2.2.23' type='text/css' media='all' /><link rel='stylesheet' id='grunion-menu-alter-css'  href='http://jpcontabil.com/wp/wp-content/plugins/jetpack/modules/contact-form/css/menu-alter.min.css?ver=4.2.20' type='text/css' media='all' /><link rel='stylesheet' id='jetpack-icons-css'  href='http://jpcontabil.com/wp/wp-content/plugins/jetpack/css/jetpack-icons.min.css?ver=3.6.1' type='text/css' media='all' />		<script type=\"text/javascript\">			window._wpemojiSettings = {\"baseUrl\":\"http:\\/\\/s.w.org\\/images\\/core\\/emoji\\/72x72\\/\",\"ext\":\".png\",\"source\":{\"concatemoji\":\"http:\\/\\/jpcontabil.com\\/wp\\/wp-includes\\/js\\/wp-emoji-release.min.js?ver=4.2.20\"}};			!function(a,b,c){function d(a){var c=b.createElement(\"canvas\"),d=c.getContext&&c.getContext(\"2d\");return d&&d.fillText?(d.textBaseline=\"top\",d.font=\"600 32px Arial\",\"flag\"===a?(d.fillText(String.fromCharCode(55356,56812,55356,56807),0,0),c.toDataURL().length>3e3):(d.fillText(String.fromCharCode(55357,56835),0,0),0!==d.getImageData(16,16,1,1).data[0])):!1}function e(a){var c=b.createElement(\"script\");c.src=a,c.type=\"text/javascript\",b.getElementsByTagName(\"head\")[0].appendChild(c)}var f,g;c.supports={simple:d(\"simple\"),flag:d(\"flag\")},c.DOMReady=!1,c.readyCallback=function(){c.DOMReady=!0},c.supports.simple&&c.supports.flag||(g=function(){c.readyCallback()},b.addEventListener?(b.addEventListener(\"DOMContentLoaded\",g,!1),a.addEventListener(\"load\",g,!1)):(a.attachEvent(\"onload\",g),b.attachEvent(\"onreadystatechange\",function(){\"complete\"===b.readyState&&c.readyCallback()})),f=c.source||{},f.concatemoji?e(f.concatemoji):f.wpemoji&&f.twemoji&&(e(f.twemoji),e(f.wpemoji)))}(window,document,window._wpemojiSettings);		</script>		<script type='text/javascript'>/* <![CDATA[ */var slideshow_jquery_image_gallery_backend_script_shortcode = {\"data\":{\"shortcode\":\"slideshow_deploy\"},\"localization\":{\"undefinedSlideshow\":\"Nenhum slideshow selecionado.\"}};/* ]]> */</script><script type='text/javascript'>/* <![CDATA[ */var userSettings = {\"url\":\"\\/wp\\/\",\"uid\":\"1\",\"time\":\"1522950435\",\"secure\":\"\"};var wpColorPickerL10n = {\"clear\":\"Limpar\",\"defaultString\":\"Padr\\u00e3o\",\"pick\":\"Selecionar Cor\",\"current\":\"Cor atual\"};/* ]]> */</script><script type='text/javascript' src='http://jpcontabil.com/wp/wp-admin/load-scripts.php?c=1&amp;load%5B%5D=jquery-core,jquery-migrate,utils,jquery-ui-core,jquery-ui-widget,jquery-ui-mouse,jquery-ui-sortable,jquery-ui-draggable,jquery-u&amp;load%5B%5D=i-slider,jquery-touch-punch,iris,wp-color-picker&amp;ver=4.2.20'></script><script type='text/javascript' src='http://jpcontabil.com/wp/wp-content/plugins/slideshow-jquery-image-gallery/js/min/all.backend.min.js?ver=2.2.23'></script><script type=\"text/javascript\">/* <![CDATA[ */	var wpNotesIsJetpackClient = true;/* ]]> */</script><script type=\"text/javascript\">var _wpColorScheme = {\"icons\":{\"base\":\"#999\",\"focus\":\"#00a0d2\",\"current\":\"#fff\"}};</script>	<link id=\"wp-admin-canonical\" rel=\"canonical\" href=\"http://jpcontabil.com/wp/wp-admin/edit.php\" />	<script>		if ( window.history.replaceState ) {			window.history.replaceState( null, null, document.getElementById( 'wp-admin-canonical' ).href + window.location.hash );		}	</script><style type=\"text/css\" media=\"print\">#wpadminbar { display:none; }</style></head><body class=\"wp-admin wp-core-ui no-js   jetpack-connected  edit-php auto-fold admin-bar post-type-post branch-4-2 version-4-2-20 admin-color-fresh locale-pt-br no-customize-support no-svg\"><script type=\"text/javascript\">	document.body.className = document.body.className.replace('no-js','js');</script>	<script type=\"text/javascript\">		(function() {			var request, b = document.body, c = 'className', cs = 'customize-support', rcs = new RegExp('(^|\\\\s+)(no-)?'+cs+'(\\\\s+|$)');			request = true;			b[c] = b[c].replace( rcs, ' ' );			b[c] += ( window.postMessage && request ? ' ' : ' no-' ) + cs;		}());	</script>	<div id=\"wpwrap\"><div id=\"adminmenumain\" role=\"navigation\" aria-label=\"Menu principal\"><a href=\"#wpbody-content\" class=\"screen-reader-shortcut\">Pular para o conteúdo principal</a><a href=\"#wp-toolbar\" class=\"screen-reader-shortcut\">Pular para a barra de ferramentas</a><div id=\"adminmenuback\"></div><div id=\"adminmenuwrap\"><ul id=\"adminmenu\">	<li class=\"wp-first-item wp-has-submenu wp-not-current-submenu menu-top menu-top-first menu-icon-dashboard menu-top-first\" id=\"menu-dashboard\">	<a href='index.php' class=\"wp-first-item wp-has-submenu wp-not-current-submenu menu-top menu-top-first menu-icon-dashboard menu-top-first\" aria-haspopup=\"true\"><div class=\"wp-menu-arrow\"><div></div></div><div class='wp-menu-image dashicons-before dashicons-dashboard'><br /></div><div class='wp-menu-name'>Painel</div></a>	<ul class='wp-submenu wp-submenu-wrap'><li class='wp-submenu-head'>Painel</li><li class=\"wp-first-item\"><a href='index.php' class=\"wp-first-item\">Início</a></li><li><a href='update-core.php'>Atualizações <span class='update-plugins count-8' title='1 Atualização do WordPress, 3 atualizações de plugin, 4 atualização de temas'><span class='update-count'>8</span></span></a></li></ul></li>	<li class=\"wp-has-submenu wp-not-current-submenu menu-top toplevel_page_jetpack menu-top-last\" id=\"toplevel_page_jetpack\"><a href='admin.php?page=jetpack' class=\"wp-has-submenu wp-not-current-submenu menu-top toplevel_page_jetpack menu-top-last\" aria-haspopup=\"true\"><div class=\"wp-menu-arrow\"><div></div></div><div class='wp-menu-image dashicons-before'><br /></div><div class='wp-menu-name'>Jetpack</div></a>	<ul class='wp-submenu wp-submenu-wrap'><li class='wp-submenu-head'>Jetpack</li><li class=\"wp-first-item\"><a href='admin.php?page=jetpack' class=\"wp-first-item\">Jetpack</a></li><li><a href='admin.php?page=jetpack_modules'>Configurações</a></li><li><a href='admin.php?page=omnisearch'>Omnisearch</a></li><li><a href='admin.php?page=stats'>Estatísticas do Site</a></li><li><a href='admin.php?page=akismet-key-config'>Akismet</a></li></ul></li>	<li class=\"wp-not-current-submenu wp-menu-separator\" aria-hidden=\"true\"><div class=\"separator\"></div></li>	<li class=\"wp-has-submenu wp-has-current-submenu wp-menu-open open-if-no-js menu-top menu-icon-post menu-top-first\" id=\"menu-posts\">	<a href='edit.php' class=\"wp-has-submenu wp-has-current-submenu wp-menu-open open-if-no-js menu-top menu-icon-post menu-top-first\" ><div class=\"wp-menu-arrow\"><div></div></div><div class='wp-menu-image dashicons-before dashicons-admin-post'><br /></div><div class='wp-menu-name'>Posts</div></a>	<ul class='wp-submenu wp-submenu-wrap'><li class='wp-submenu-head'>Posts</li><li class=\"wp-first-item current\"><a href='edit.php' class=\"wp-first-item current\">Todos os Posts</a></li><li><a href='post-new.php'>Adicionar Novo</a></li><li><a href='edit-tags.php?taxonomy=category'>Categorias</a></li><li><a href='edit-tags.php?taxonomy=post_tag'>Tags</a></li></ul></li>	<li class=\"wp-has-submenu wp-not-current-submenu menu-top menu-icon-media\" id=\"menu-media\">	<a href='upload.php' class=\"wp-has-submenu wp-not-current-submenu menu-top menu-icon-media\" aria-haspopup=\"true\"><div class=\"wp-menu-arrow\"><div></div></div><div class='wp-menu-image dashicons-before dashicons-admin-media'><br /></div><div class='wp-menu-name'>Mídia</div></a>	<ul class='wp-submenu wp-submenu-wrap'><li class='wp-submenu-head'>Mídia</li><li class=\"wp-first-item\"><a href='upload.php' class=\"wp-first-item\">Biblioteca</a></li><li><a href='media-new.php'>Adicionar Nova</a></li></ul></li>	<li class=\"wp-has-submenu wp-not-current-submenu menu-top menu-icon-page\" id=\"menu-pages\">	<a href='edit.php?post_type=page' class=\"wp-has-submenu wp-not-current-submenu menu-top menu-icon-page\" aria-haspopup=\"true\"><div class=\"wp-menu-arrow\"><div></div></div><div class='wp-menu-image dashicons-before dashicons-admin-page'><br /></div><div class='wp-menu-name'>Páginas</div></a>	<ul class='wp-submenu wp-submenu-wrap'><li class='wp-submenu-head'>Páginas</li><li class=\"wp-first-item\"><a href='edit.php?post_type=page' class=\"wp-first-item\">Todas as Páginas</a></li><li><a href='post-new.php?post_type=page'>Adicionar Nova</a></li></ul></li>	<li class=\"wp-not-current-submenu menu-top menu-icon-comments\" id=\"menu-comments\">	<a href='edit-comments.php' class=\"wp-not-current-submenu menu-top menu-icon-comments\" ><div class=\"wp-menu-arrow\"><div></div></div><div class='wp-menu-image dashicons-before dashicons-admin-comments'><br /></div><div class='wp-menu-name'>Comentários <span class='awaiting-mod count-0'><span class='pending-count'>0</span></span></div></a></li>	<li class=\"wp-has-submenu wp-not-current-submenu menu-top menu-icon-slideshow\" id=\"menu-posts-slideshow\">	<a href='edit.php?post_type=slideshow' class=\"wp-has-submenu wp-not-current-submenu menu-top menu-icon-slideshow\" aria-haspopup=\"true\"><div class=\"wp-menu-arrow\"><div></div></div><div class='wp-menu-image dashicons-before dashicons-format-gallery'><br /></div><div class='wp-menu-name'>Slideshows</div></a>	<ul class='wp-submenu wp-submenu-wrap'><li class='wp-submenu-head'>Slideshows</li><li class=\"wp-first-item\"><a href='edit.php?post_type=slideshow' class=\"wp-first-item\">Slideshows</a></li><li><a href='post-new.php?post_type=slideshow'>Adicionar Novo</a></li><li><a href='edit.php?post_type=slideshow&#038;page=general_settings'>Configurações Gerais</a></li></ul></li>	<li class=\"wp-not-current-submenu menu-top menu-icon-feedback menu-top-last\" id=\"menu-posts-feedback\">	<a href='edit.php?post_type=feedback' class=\"wp-not-current-submenu menu-top menu-icon-feedback menu-top-last\" ><div class=\"wp-menu-arrow\"><div></div></div><div class='wp-menu-image dashicons-before'><img src=\"http://jpcontabil.com/wp/wp-content/plugins/jetpack/modules/contact-form//images/grunion-menu.png\" alt=\"\" /></div><div class='wp-menu-name'>Feedback</div></a></li>	<li class=\"wp-not-current-submenu wp-menu-separator\" aria-hidden=\"true\"><div class=\"separator\"></div></li>	<li class=\"wp-has-submenu wp-not-current-submenu menu-top menu-icon-appearance menu-top-first\" id=\"menu-appearance\">	<a href='themes.php' class=\"wp-has-submenu wp-not-current-submenu menu-top menu-icon-appearance menu-top-first\" aria-haspopup=\"true\"><div class=\"wp-menu-arrow\"><div></div></div><div class='wp-menu-image dashicons-before dashicons-admin-appearance'><br /></div><div class='wp-menu-name'>Aparência</div></a>	<ul class='wp-submenu wp-submenu-wrap'><li class='wp-submenu-head'>Aparência</li><li class=\"wp-first-item\"><a href='themes.php' class=\"wp-first-item\">Temas</a></li><li class=\"hide-if-no-customize\"><a href='customize.php?return=%2Fwp%2Fwp-admin%2Fedit.php' class=\"hide-if-no-customize\">Personalizar</a></li><li><a href='widgets.php'>Widgets</a></li><li><a href='nav-menus.php'>Menus</a></li><li class=\"hide-if-no-customize\"><a href='customize.php?return=%2Fwp%2Fwp-admin%2Fedit.php&#038;autofocus%5Bcontrol%5D=header_image' class=\"hide-if-no-customize\">Cabeçalho</a></li><li class=\"hide-if-no-customize\"><a href='customize.php?return=%2Fwp%2Fwp-admin%2Fedit.php&#038;autofocus%5Bcontrol%5D=background_image' class=\"hide-if-no-customize\">Fundo</a></li><li><a href='themes.php?page=editcss'>Editar CSS</a></li><li><a href='themes.php?page=custom-header'>Cabeçalho</a></li><li><a href='themes.php?page=custom-background'>Fundo</a></li><li><a href='theme-editor.php'>Editor</a></li></ul></li>	<li class=\"wp-has-submenu wp-not-current-submenu menu-top menu-icon-plugins\" id=\"menu-plugins\">	<a href='plugins.php' class=\"wp-has-submenu wp-not-current-submenu menu-top menu-icon-plugins\" aria-haspopup=\"true\"><div class=\"wp-menu-arrow\"><div></div></div><div class='wp-menu-image dashicons-before dashicons-admin-plugins'><br /></div><div class='wp-menu-name'>Plugins <span class='update-plugins count-3'><span class='plugin-count'>3</span></span></div></a>	<ul class='wp-submenu wp-submenu-wrap'><li class='wp-submenu-head'>Plugins <span class='update-plugins count-3'><span class='plugin-count'>3</span></span></li><li class=\"wp-first-item\"><a href='plugins.php' class=\"wp-first-item\">Plugins Instalados</a></li><li><a href='plugin-install.php'>Adicionar Novo</a></li><li><a href='plugin-editor.php'>Editor</a></li></ul></li>	<li class=\"wp-has-submenu wp-not-current-submenu menu-top menu-icon-users\" id=\"menu-users\">	<a href='users.php' class=\"wp-has-submenu wp-not-current-submenu menu-top menu-icon-users\" aria-haspopup=\"true\"><div class=\"wp-menu-arrow\"><div></div></div><div class='wp-menu-image dashicons-before dashicons-admin-users'><br /></div><div class='wp-menu-name'>Usuários</div></a>	<ul class='wp-submenu wp-submenu-wrap'><li class='wp-submenu-head'>Usuários</li><li class=\"wp-first-item\"><a href='users.php' class=\"wp-first-item\">Todos os Usuários</a></li><li><a href='user-new.php'>Adicionar Novo</a></li><li><a href='profile.php'>Seu perfil</a></li></ul></li>	<li class=\"wp-has-submenu wp-not-current-submenu menu-top menu-icon-tools\" id=\"menu-tools\">	<a href='tools.php' class=\"wp-has-submenu wp-not-current-submenu menu-top menu-icon-tools\" aria-haspopup=\"true\"><div class=\"wp-menu-arrow\"><div></div></div><div class='wp-menu-image dashicons-before dashicons-admin-tools'><br /></div><div class='wp-menu-name'>Ferramentas</div></a>	<ul class='wp-submenu wp-submenu-wrap'><li class='wp-submenu-head'>Ferramentas</li><li class=\"wp-first-item\"><a href='tools.php' class=\"wp-first-item\">Disponíveis</a></li><li><a href='import.php'>Importar</a></li><li><a href='export.php'>Exportar</a></li></ul></li>	<li class=\"wp-has-submenu wp-not-current-submenu menu-top menu-icon-settings menu-top-last\" id=\"menu-settings\">	<a href='options-general.php' class=\"wp-has-submenu wp-not-current-submenu menu-top menu-icon-settings menu-top-last\" aria-haspopup=\"true\"><div class=\"wp-menu-arrow\"><div></div></div><div class='wp-menu-image dashicons-before dashicons-admin-settings'><br /></div><div class='wp-menu-name'>Configurações</div></a>	<ul class='wp-submenu wp-submenu-wrap'><li class='wp-submenu-head'>Configurações</li><li class=\"wp-first-item\"><a href='options-general.php' class=\"wp-first-item\">Geral</a></li><li><a href='options-writing.php'>Escrita</a></li><li><a href='options-reading.php'>Leitura</a></li><li><a href='options-discussion.php'>Discussão</a></li><li><a href='options-media.php'>Mídia</a></li><li><a href='options-permalink.php'>Links Permanentes</a></li><li><a href='options-general.php?page=updraftplus'>Backups do UpdraftPlus</a></li><li><a href='options-general.php?page=sharing'>Compartilhar</a></li></ul></li><li id=\"collapse-menu\" class=\"hide-if-no-js\"><div id=\"collapse-button\"><div></div></div><span>Recolher Menu</span></li></ul></div></div><div id=\"wpcontent\">		<div id=\"wpadminbar\" class=\"nojq nojs\">						<div class=\"quicklinks\" id=\"wp-toolbar\" role=\"navigation\" aria-label=\"Barra de Ferramentas\" tabindex=\"0\">				<ul id=\"wp-admin-bar-root-default\" class=\"ab-top-menu\">		<li id=\"wp-admin-bar-menu-toggle\"><a class=\"ab-item\"  href=\"#\"><span class=\"ab-icon\"></span><span class=\"screen-reader-text\">Menu</span></a>		</li>		<li id=\"wp-admin-bar-site-name\" class=\"menupop\"><a class=\"ab-item\"  aria-haspopup=\"true\" href=\"http://jpcontabil.com/wp/\">JP Contábil &amp; Filhos</a><div class=\"ab-sub-wrapper\"><ul id=\"wp-admin-bar-site-name-default\" class=\"ab-submenu\">		<li id=\"wp-admin-bar-view-site\"><a class=\"ab-item\"  href=\"http://jpcontabil.com/wp/\">Visitar site</a>		</li></ul></div>		</li>		<li id=\"wp-admin-bar-updates\"><a class=\"ab-item\"  href=\"http://jpcontabil.com/wp/wp-admin/update-core.php\" title=\"1 Atualização do WordPress, 3 atualizações de plugin, 4 atualização de temas\"><span class=\"ab-icon\"></span><span class=\"ab-label\">8</span><span class=\"screen-reader-text\">1 Atualização do WordPress, 3 atualizações de plugin, 4 atualização de temas</span></a>		</li>		<li id=\"wp-admin-bar-comments\"><a class=\"ab-item\"  href=\"http://jpcontabil.com/wp/wp-admin/edit-comments.php\" title=\"0 comentário aguarda moderação\"><span class=\"ab-icon\"></span><span id=\"ab-awaiting-mod\" class=\"ab-label awaiting-mod pending-count count-0\">0</span></a>		</li>		<li id=\"wp-admin-bar-new-content\" class=\"menupop\"><a class=\"ab-item\"  aria-haspopup=\"true\" href=\"http://jpcontabil.com/wp/wp-admin/post-new.php\"><span class=\"ab-icon\"></span><span class=\"ab-label\">Novo</span></a><div class=\"ab-sub-wrapper\"><ul id=\"wp-admin-bar-new-content-default\" class=\"ab-submenu\">		<li id=\"wp-admin-bar-new-post\"><a class=\"ab-item\"  href=\"http://jpcontabil.com/wp/wp-admin/post-new.php\">Post</a>		</li>		<li id=\"wp-admin-bar-new-media\"><a class=\"ab-item\"  href=\"http://jpcontabil.com/wp/wp-admin/media-new.php\">Mídia</a>		</li>		<li id=\"wp-admin-bar-new-page\"><a class=\"ab-item\"  href=\"http://jpcontabil.com/wp/wp-admin/post-new.php?post_type=page\">Página</a>		</li>		<li id=\"wp-admin-bar-new-slideshow\"><a class=\"ab-item\"  href=\"http://jpcontabil.com/wp/wp-admin/post-new.php?post_type=slideshow\">Slideshow</a>		</li>		<li id=\"wp-admin-bar-new-user\"><a class=\"ab-item\"  href=\"http://jpcontabil.com/wp/wp-admin/user-new.php\">Usuário</a>		</li></ul></div>		</li></ul><ul id=\"wp-admin-bar-top-secondary\" class=\"ab-top-secondary ab-top-menu\">		<li id=\"wp-admin-bar-search\" class=\"admin-bar-search\"><div class=\"ab-item ab-empty-item\" tabindex=\"-1\">		<form action=\"http://jpcontabil.com/wp/wp-admin/admin.php\" method=\"get\" class=\"\" id=\"adminbarsearch\">			<input type=\"hidden\" name=\"page\" value=\"omnisearch\" />			<input name=\"s\" type=\"search\" class=\"adminbar-input\" id=\"adminbar-search\" value=\"\" placeholder=\"pesquise tudo\" />							<input type=\"submit\" class=\"adminbar-button\" value=\"Pesquisa\" />					</form>		<style>				#adminbar-search::-webkit-input-placeholder,				#adminbar-search:-moz-placeholder,				#adminbar-search::-moz-placeholder,				#adminbar-search:-ms-input-placeholder {					text-shadow: none;				}			</style></div>		</li>		<li id=\"wp-admin-bar-my-account\" class=\"menupop with-avatar\"><a class=\"ab-item\"  aria-haspopup=\"true\" href=\"http://jpcontabil.com/wp/wp-admin/profile.php\">Olá, pmateus<img alt='' src='http://2.gravatar.com/avatar/85998bd216117bfcc9e26f0f8155d2f2?s=26&#038;d=mm&#038;r=g' srcset='http://2.gravatar.com/avatar/85998bd216117bfcc9e26f0f8155d2f2?s=52&amp;d=mm&amp;r=g 2x' class='avatar avatar-26 photo' height='26' width='26' /></a><div class=\"ab-sub-wrapper\"><ul id=\"wp-admin-bar-user-actions\" class=\"ab-submenu\">		<li id=\"wp-admin-bar-user-info\"><a class=\"ab-item\" tabindex=\"-1\" href=\"http://jpcontabil.com/wp/wp-admin/profile.php\"><img alt='' src='http://2.gravatar.com/avatar/85998bd216117bfcc9e26f0f8155d2f2?s=64&#038;d=mm&#038;r=g' srcset='http://2.gravatar.com/avatar/85998bd216117bfcc9e26f0f8155d2f2?s=128&amp;d=mm&amp;r=g 2x' class='avatar avatar-64 photo' height='64' width='64' /><span class='display-name'>pmateus</span></a>		</li>		<li id=\"wp-admin-bar-edit-profile\"><a class=\"ab-item\"  href=\"http://jpcontabil.com/wp/wp-admin/profile.php\">Editar Meu Perfil</a>		</li>		<li id=\"wp-admin-bar-logout\"><a class=\"ab-item\"  href=\"http://jpcontabil.com/wp/wp-login.php?action=logout&#038;_wpnonce=1ed4005e68\">Sair</a>		</li></ul></div>		</li>		<li id=\"wp-admin-bar-notes\" class=\"menupop\"><div class=\"ab-item ab-empty-item\" ><span id=\"wpnt-notes-unread-count\" class=\"wpnt-loading wpn-read\">					<span class=\"noticon noticon-notification\"></span>					</span></div><div id=\"wpnt-notes-panel\" style=\"display:none\" lang=\"pt_BR\" dir=\"ltr\"><div class=\"wpnt-notes-panel-header\"><span class=\"wpnt-notes-header\">Notificações</span><span class=\"wpnt-notes-panel-link\"></span></div></div>		</li></ul>			</div>						<a class=\"screen-reader-shortcut\" href=\"http://jpcontabil.com/wp/wp-login.php?action=logout&#038;_wpnonce=1ed4005e68\">Sair</a>					</div>		<div id=\"wpbody\" role=\"main\"><div id=\"wpbody-content\" aria-label=\"Conteúdo principal\" tabindex=\"0\">		<div id=\"screen-meta\" class=\"metabox-prefs\">			<div id=\"contextual-help-wrap\" class=\"hidden\" tabindex=\"-1\" aria-label=\"Aba de Ajuda Contextual\">				<div id=\"contextual-help-back\"></div>				<div id=\"contextual-help-columns\">					<div class=\"contextual-help-tabs\">						<ul>													<li id=\"tab-link-overview\" class=\"active\">								<a href=\"#tab-panel-overview\" aria-controls=\"tab-panel-overview\">									Visão Geral								</a>							</li>													<li id=\"tab-link-screen-content\">								<a href=\"#tab-panel-screen-content\" aria-controls=\"tab-panel-screen-content\">									Conteúdo da Tela								</a>							</li>													<li id=\"tab-link-action-links\">								<a href=\"#tab-panel-action-links\" aria-controls=\"tab-panel-action-links\">									Ações Disponíveis								</a>							</li>													<li id=\"tab-link-bulk-actions\">								<a href=\"#tab-panel-bulk-actions\" aria-controls=\"tab-panel-bulk-actions\">									Ações em massa								</a>							</li>												</ul>					</div>										<div class=\"contextual-help-sidebar\">						<p><strong>Para mais informações:</strong></p><p><a href=\"https://codex.wordpress.org/pt-br:Painel_Posts\" target=\"_blank\">Documentação sobre Gerenciamento de Posts</a></p><p><a href=\"https://wordpress.org/support/\" target=\"_blank\">Fóruns de Suporte</a></p>					</div>										<div class=\"contextual-help-tabs-wrap\">													<div id=\"tab-panel-overview\" class=\"help-tab-content active\">								<p>Esta tela oferece acesso a todos os seus posts. Personalize sua exibição para que se adapte ao seu ritmo de trabalho.</p>							</div>													<div id=\"tab-panel-screen-content\" class=\"help-tab-content\">								<p>Você pode personalizar a exibição do conteúdo desta tela das seguintes maneiras:</p><ul><li>Você pode ocultar/exibir colunas com base em suas necessidades e decidir quantos posts listar por tela através da aba Opções de Tela.</li><li>Você pode filtrar a lista de posts por status usando os links acima à esquerda para mostrar Todos, Publicados, Rascunhos, ou os movidos para a Lixeira. A visualização padrão exibe todos os posts.</li><li>Você pode ver os posts em uma lista de títulos simples ou com o resumo. Escolha a visualização preferida clicando nos ícones no canto superior direito da lista de posts.</li><li>Você pode refinar a lista para mostrar apenas posts de uma categoria específica, ou de um mês específico usando as listas suspensas acima da lista de posts. Clique no botão Filtrar após fazer sua seleção. Você também pode refinar a lista clicando no autor, categoria ou tag do post na lista de posts.</li></ul>							</div>													<div id=\"tab-panel-action-links\" class=\"help-tab-content\">								<p>Ao passar o cursor sobre uma linha na lista de posts, serão exibidos os links de ação que lhe permitem administrar o seu post. Você pode realizar as seguintes ações:</p><ul><li><strong>Editar</strong> leva você para a tela de edição para esse post. Você também pode chegar a essa tela, clicando sobre o título do post.</li><li><strong>Edição Rápida</strong> oferece acesso para metadados do seu post, o que lhe permite atualizar os dados do post, sem sair desta tela.</li><li><strong>Excluir</strong> remove o seu post desta lista e o coloca na Lixeira, a partir da qual você pode excluí-lo permanentemente.</li><li><strong>Pré-visualizar</strong> vai mostrar como seu post ficará em seu site, antes de publicá-lo. Ver o levará para o seu site ao vivo para ver o post. Qual link está disponível depende do status do seu post.</li></ul>							</div>													<div id=\"tab-panel-bulk-actions\" class=\"help-tab-content\">								<p>Você também pode editar ou mover múltiplos posts para a Lixeira de uma só vez. Selecione os posts que quer atuar clicando em suas caixas de seleção, em seguida, selecione a ação a ser tomada no menu Ações em massa, depois no botão Aplicar.</p><p>Quando se usa Edição em Massa, você pode alterar os metadados (categorias, autor, etc) para todos os posts selecionados de uma só vez. Para remover um post do agrupamento, basta clicar no x ao lado de seu nome na área de Edição em Massa que aparece.</p>							</div>											</div>				</div>			</div>				<div id=\"screen-options-wrap\" class=\"hidden\" tabindex=\"-1\" aria-label=\"Aba de Opções da Tela\">		<form id=\"adv-settings\" method=\"post\">					<h5>Mostrar na tela</h5>					<div class=\"metabox-prefs\">				<label for=\"author-hide\"><input class=\"hide-column-tog\" name=\"author-hide\" type=\"checkbox\" id=\"author-hide\" value=\"author\" checked='checked' />Autor</label><label for=\"categories-hide\"><input class=\"hide-column-tog\" name=\"categories-hide\" type=\"checkbox\" id=\"categories-hide\" value=\"categories\" checked='checked' />Categorias</label><label for=\"tags-hide\"><input class=\"hide-column-tog\" name=\"tags-hide\" type=\"checkbox\" id=\"tags-hide\" value=\"tags\" checked='checked' />Tags</label><label for=\"comments-hide\"><input class=\"hide-column-tog\" name=\"comments-hide\" type=\"checkbox\" id=\"comments-hide\" value=\"comments\" checked='checked' />Comentários</label><label for=\"date-hide\"><input class=\"hide-column-tog\" name=\"date-hide\" type=\"checkbox\" id=\"date-hide\" value=\"date\" checked='checked' />Data</label>				<br class=\"clear\" />			</div>				<div class=\"screen-options\">							<label for=\"edit_post_per_page\">Número de itens por página:</label>				<input type=\"number\" step=\"1\" min=\"1\" max=\"999\" class=\"screen-per-page\" name=\"wp_screen_options[value]\"					id=\"edit_post_per_page\" maxlength=\"3\"					value=\"20\" />			<input type=\"submit\" name=\"screen-options-apply\" id=\"screen-options-apply\" class=\"button\" value=\"Aplicar\"  />			<input type=\"hidden\" name=\"wp_screen_options[option]\" value=\"edit_post_per_page\" />		</div>				<div><input type=\"hidden\" id=\"screenoptionnonce\" name=\"screenoptionnonce\" value=\"e4959d0bd8\" /></div>		</form>		</div>				</div>				<div id=\"screen-meta-links\">					<div id=\"contextual-help-link-wrap\" class=\"hide-if-no-js screen-meta-toggle\">			<a href=\"#contextual-help-wrap\" id=\"contextual-help-link\" class=\"show-settings\" aria-controls=\"contextual-help-wrap\" aria-expanded=\"false\">Ajuda</a>			</div>					<div id=\"screen-options-link-wrap\" class=\"hide-if-no-js screen-meta-toggle\">			<a href=\"#screen-options-wrap\" id=\"show-settings-link\" class=\"show-settings\" aria-controls=\"screen-options-wrap\" aria-expanded=\"false\">Opções de Tela</a>			</div>				</div>		<div class='update-nag'>O <a href=\"https://codex.wordpress.org/Version_4.9.5\">WordPress 4.9.5</a> está disponível! <a href=\"http://jpcontabil.com/wp/wp-admin/update-core.php\">Atualize agora</a>.</div><div class=\"wrap\"><h2>Posts <a href=\"http://jpcontabil.com/wp/wp-admin/post-new.php\" class=\"add-new-h2\">Adicionar Novo</a></h2><ul class='subsubsub'>	<li class='all'><a href='edit.php?post_type=post' class=\"current\">Tudo <span class=\"count\">(99)</span></a> |</li>	<li class='publish'><a href='edit.php?post_status=publish&amp;post_type=post'>Publicados <span class=\"count\">(97)</span></a> |</li>	<li class='draft'><a href='edit.php?post_status=draft&amp;post_type=post'>Rascunhos <span class=\"count\">(2)</span></a></li></ul><form id=\"posts-filter\" method=\"get\"><p class=\"search-box\">	<label class=\"screen-reader-text\" for=\"post-search-input\">Pesquisar posts:</label>	<input type=\"search\" id=\"post-search-input\" name=\"s\" value=\"\" />	<input type=\"submit\" id=\"search-submit\" class=\"button\" value=\"Pesquisar posts\"  /></p><input type=\"hidden\" name=\"post_status\" class=\"post_status_page\" value=\"all\" /><input type=\"hidden\" name=\"post_type\" class=\"post_type_page\" value=\"post\" /><input type=\"hidden\" id=\"_wpnonce\" name=\"_wpnonce\" value=\"a11cd72002\" /><input type=\"hidden\" name=\"_wp_http_referer\" value=\"/wp/wp-admin/edit.php\" />	<div class=\"tablenav top\">		<div class=\"alignleft actions bulkactions\">			<label for='bulk-action-selector-top' class='screen-reader-text'>Selecionar ação em massa</label><select name='action' id='bulk-action-selector-top'><option value='-1' selected='selected'>Ações em massa</option>	<option value='edit' class=\"hide-if-no-js\">Editar</option>	<option value='trash'>Mover para a lixeira</option></select><input type=\"submit\" id=\"doaction\" class=\"button action\" value=\"Aplicar\"  />		</div>		<div class=\"alignleft actions\">		<label for=\"filter-by-date\" class=\"screen-reader-text\">Filtrar por data</label>		<select name=\"m\" id=\"filter-by-date\">			<option selected='selected' value=\"0\">Todas as datas</option><option  value='201701'>janeiro 2017</option><option  value='201612'>dezembro 2016</option><option  value='201611'>novembro 2016</option><option  value='201610'>outubro 2016</option><option  value='201609'>setembro 2016</option><option  value='201602'>fevereiro 2016</option><option  value='201601'>janeiro 2016</option><option  value='201512'>dezembro 2015</option><option  value='201511'>novembro 2015</option><option  value='201510'>outubro 2015</option><option  value='201509'>setembro 2015</option><option  value='201508'>agosto 2015</option><option  value='201507'>julho 2015</option><option  value='201506'>junho 2015</option><option  value='201412'>dezembro 2014</option><option  value='201408'>agosto 2014</option><option  value='201407'>julho 2014</option><option  value='201406'>junho 2014</option><option  value='201404'>abril 2014</option>		</select><label class=\"screen-reader-text\" for=\"cat\">Filtrar por categoria</label><select name='cat' id='cat' class='postform' >	<option value='0'>Todas categorias</option>	<option class=\"level-0\" value=\"1\">Sem categoria</option></select><input type=\"submit\" name=\"filter_action\" id=\"post-query-submit\" class=\"button\" value=\"Filtrar\"  />		</div><div class='tablenav-pages'><span class=\"displaying-num\">99 itens</span><span class='pagination-links'><a class='first-page disabled' title='Ir para a primeira página' href='http://jpcontabil.com/wp/wp-admin/edit.php'>&laquo;</a><a class='prev-page disabled' title='Ir para a página anterior' href='http://jpcontabil.com/wp/wp-admin/edit.php?paged=1'>&lsaquo;</a><span class=\"paging-input\"><label for=\"current-page-selector\" class=\"screen-reader-text\">Selecionar Página</label><input class='current-page' id='current-page-selector' title='Página atual' type='text' name='paged' value='1' size='1' /> de <span class='total-pages'>5</span></span><a class='next-page' title='Ir para a próxima página' href='http://jpcontabil.com/wp/wp-admin/edit.php?paged=2'>&rsaquo;</a><a class='last-page' title='Ir para a última página' href='http://jpcontabil.com/wp/wp-admin/edit.php?paged=5'>&raquo;</a></span></div>		<input type=\"hidden\" name=\"mode\" value=\"list\" />		<div class=\"view-switch\"><a href='/wp/wp-admin/edit.php?mode=list' class='view-list current' id='view-switch-list'><span class='screen-reader-text'>Visualização em lista</span></a><a href='/wp/wp-admin/edit.php?mode=excerpt' class='view-excerpt' id='view-switch-excerpt'><span class='screen-reader-text'>Visualização do resumo</span></a>		</div>		<br class=\"clear\" />	</div><table class=\"wp-list-table widefat fixed striped posts\">	<thead>	<tr>		<th scope='col' id='cb' class='manage-column column-cb check-column'  style=\"\"><label class=\"screen-reader-text\" for=\"cb-select-all-1\">Selecionar todos</label><input id=\"cb-select-all-1\" type=\"checkbox\" /></th><th scope='col' id='title' class='manage-column column-title sortable desc'  style=\"\"><a href=\"http://jpcontabil.com/wp/wp-admin/edit.php?orderby=title&#038;order=asc\"><span>Título</span><span class=\"sorting-indicator\"></span></a></th><th scope='col' id='author' class='manage-column column-author'  style=\"\">Autor</th><th scope='col' id='categories' class='manage-column column-categories'  style=\"\">Categorias</th><th scope='col' id='tags' class='manage-column column-tags'  style=\"\">Tags</th><th scope='col' id='comments' class='manage-column column-comments num sortable desc'  style=\"\"><a href=\"http://jpcontabil.com/wp/wp-admin/edit.php?orderby=comment_count&#038;order=asc\"><span><span class=\"vers comment-grey-bubble\" title=\"Comentários\"><span class=\"screen-reader-text\">Comentários</span></span></span><span class=\"sorting-indicator\"></span></a></th><th scope='col' id='date' class='manage-column column-date sortable asc'  style=\"\"><a href=\"http://jpcontabil.com/wp/wp-admin/edit.php?orderby=date&#038;order=desc\"><span>Data</span><span class=\"sorting-indicator\"></span></a></th>	</tr>	</thead>	<tbody id=\"the-list\">				<tr id=\"post-979\" class=\"iedit author-other level-0 post-979 type-post status-publish format-standard hentry category-sem-categoria\">				<th scope=\"row\" class=\"check-column\">								<label class=\"screen-reader-text\" for=\"cb-select-979\">Selecionar Entrega da DCTF das empresas inativas</label>				<input id=\"cb-select-979\" type=\"checkbox\" name=\"post[]\" value=\"979\" />				<div class=\"locked-indicator\"></div>							</th>			<td class=\"post-title page-title column-title\"><strong><a class=\"row-title\" href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=979&amp;action=edit\" title=\"Editar &#8220;Entrega da DCTF das empresas inativas&#8221;\">Entrega da DCTF das empresas inativas</a></strong><div class=\"locked-info\"><span class=\"locked-avatar\"></span> <span class=\"locked-text\"></span></div><div class=\"row-actions\"><span class='edit'><a href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=979&amp;action=edit\" title=\"Editar este item\">Editar</a> | </span><span class='inline hide-if-no-js'><a href=\"#\" class=\"editinline\" title=\"Editar este item diretamente\">Edição rápida</a> | </span><span class='trash'><a class='submitdelete' title='Mover este item para a Lixeira' href='http://jpcontabil.com/wp/wp-admin/post.php?post=979&amp;action=trash&amp;_wpnonce=4060c36e6e'>Lixeira</a> | </span><span class='view'><a href=\"http://jpcontabil.com/wp/2017/01/13/entrega-da-dctf-das-empresas-inativas/\" title=\"Ver &#8220;Entrega da DCTF das empresas inativas&#8221;\" rel=\"permalink\">Ver</a></span></div><div class=\"hidden\" id=\"inline_979\">	<div class=\"post_title\">Entrega da DCTF das empresas inativas</div>	<div class=\"post_name\">entrega-da-dctf-das-empresas-inativas</div>	<div class=\"post_author\">59</div>	<div class=\"comment_status\">closed</div>	<div class=\"ping_status\">open</div>	<div class=\"_status\">publish</div>	<div class=\"jj\">13</div>	<div class=\"mm\">01</div>	<div class=\"aa\">2017</div>	<div class=\"hh\">12</div>	<div class=\"mn\">06</div>	<div class=\"ss\">19</div>	<div class=\"post_password\"></div><div class=\"post_category\" id=\"category_979\">1</div><div class=\"tags_input\" id=\"post_tag_979\"></div><div class=\"sticky\"></div><div class=\"post_format\"></div></div></td>			<td class=\"author column-author\"><a href=\"edit.php?post_type=post&#038;author=59\">José Paulo</a></td>			<td class=\"categories column-categories\"><a href=\"edit.php?category_name=sem-categoria\">Sem categoria</a></td><td class=\"tags column-tags\">&#8212;</td>			<td class=\"comments column-comments\"><div class=\"post-com-count-wrapper\">			<a href='http://jpcontabil.com/wp/wp-admin/edit-comments.php?p=979' title='0 pendente(s)' class='post-com-count'><span class='comment-count'>0</span></a>			</div></td>			<td class=\"date column-date\"><abbr title=\"13/01/2017 12:06:19\">13/01/2017</abbr><br />Publicado</td>		</tr>			<tr id=\"post-977\" class=\"iedit author-other level-0 post-977 type-post status-publish format-standard hentry category-sem-categoria\">				<th scope=\"row\" class=\"check-column\">								<label class=\"screen-reader-text\" for=\"cb-select-977\">Selecionar Renegociação do Simples Nacional vai até 31 de janeiro</label>				<input id=\"cb-select-977\" type=\"checkbox\" name=\"post[]\" value=\"977\" />				<div class=\"locked-indicator\"></div>							</th>			<td class=\"post-title page-title column-title\"><strong><a class=\"row-title\" href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=977&amp;action=edit\" title=\"Editar &#8220;Renegociação do Simples Nacional vai até 31 de janeiro&#8221;\">Renegociação do Simples Nacional vai até 31 de janeiro</a></strong><div class=\"locked-info\"><span class=\"locked-avatar\"></span> <span class=\"locked-text\"></span></div><div class=\"row-actions\"><span class='edit'><a href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=977&amp;action=edit\" title=\"Editar este item\">Editar</a> | </span><span class='inline hide-if-no-js'><a href=\"#\" class=\"editinline\" title=\"Editar este item diretamente\">Edição rápida</a> | </span><span class='trash'><a class='submitdelete' title='Mover este item para a Lixeira' href='http://jpcontabil.com/wp/wp-admin/post.php?post=977&amp;action=trash&amp;_wpnonce=0dde1cba42'>Lixeira</a> | </span><span class='view'><a href=\"http://jpcontabil.com/wp/2017/01/13/renegociacao-do-simples-nacional-vai-ate-31-de-janeiro/\" title=\"Ver &#8220;Renegociação do Simples Nacional vai até 31 de janeiro&#8221;\" rel=\"permalink\">Ver</a></span></div><div class=\"hidden\" id=\"inline_977\">	<div class=\"post_title\">Renegociação do Simples Nacional vai até 31 de janeiro</div>	<div class=\"post_name\">renegociacao-do-simples-nacional-vai-ate-31-de-janeiro</div>	<div class=\"post_author\">59</div>	<div class=\"comment_status\">closed</div>	<div class=\"ping_status\">open</div>	<div class=\"_status\">publish</div>	<div class=\"jj\">13</div>	<div class=\"mm\">01</div>	<div class=\"aa\">2017</div>	<div class=\"hh\">12</div>	<div class=\"mn\">01</div>	<div class=\"ss\">05</div>	<div class=\"post_password\"></div><div class=\"post_category\" id=\"category_977\">1</div><div class=\"tags_input\" id=\"post_tag_977\"></div><div class=\"sticky\"></div><div class=\"post_format\"></div></div></td>			<td class=\"author column-author\"><a href=\"edit.php?post_type=post&#038;author=59\">José Paulo</a></td>			<td class=\"categories column-categories\"><a href=\"edit.php?category_name=sem-categoria\">Sem categoria</a></td><td class=\"tags column-tags\">&#8212;</td>			<td class=\"comments column-comments\"><div class=\"post-com-count-wrapper\">			<a href='http://jpcontabil.com/wp/wp-admin/edit-comments.php?p=977' title='0 pendente(s)' class='post-com-count'><span class='comment-count'>0</span></a>			</div></td>			<td class=\"date column-date\"><abbr title=\"13/01/2017 12:01:05\">13/01/2017</abbr><br />Publicado</td>		</tr>			<tr id=\"post-975\" class=\"iedit author-other level-0 post-975 type-post status-publish format-standard hentry category-sem-categoria\">				<th scope=\"row\" class=\"check-column\">								<label class=\"screen-reader-text\" for=\"cb-select-975\">Selecionar A partir de janeiro, serviços dos MEIs devem ser feitos nos escritórios de contabilidade</label>				<input id=\"cb-select-975\" type=\"checkbox\" name=\"post[]\" value=\"975\" />				<div class=\"locked-indicator\"></div>							</th>			<td class=\"post-title page-title column-title\"><strong><a class=\"row-title\" href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=975&amp;action=edit\" title=\"Editar &#8220;A partir de janeiro, serviços dos MEIs devem ser feitos nos escritórios de contabilidade&#8221;\">A partir de janeiro, serviços dos MEIs devem ser feitos nos escritórios de contabilidade</a></strong><div class=\"locked-info\"><span class=\"locked-avatar\"></span> <span class=\"locked-text\"></span></div><div class=\"row-actions\"><span class='edit'><a href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=975&amp;action=edit\" title=\"Editar este item\">Editar</a> | </span><span class='inline hide-if-no-js'><a href=\"#\" class=\"editinline\" title=\"Editar este item diretamente\">Edição rápida</a> | </span><span class='trash'><a class='submitdelete' title='Mover este item para a Lixeira' href='http://jpcontabil.com/wp/wp-admin/post.php?post=975&amp;action=trash&amp;_wpnonce=fad30d5458'>Lixeira</a> | </span><span class='view'><a href=\"http://jpcontabil.com/wp/2016/12/16/a-partir-de-janeiro-servicos-dos-meis-devem-ser-feitos-nos-escritorios-de-contabilidade/\" title=\"Ver &#8220;A partir de janeiro, serviços dos MEIs devem ser feitos nos escritórios de contabilidade&#8221;\" rel=\"permalink\">Ver</a></span></div><div class=\"hidden\" id=\"inline_975\">	<div class=\"post_title\">A partir de janeiro, serviços dos MEIs devem ser feitos nos escritórios de contabilidade</div>	<div class=\"post_name\">a-partir-de-janeiro-servicos-dos-meis-devem-ser-feitos-nos-escritorios-de-contabilidade</div>	<div class=\"post_author\">59</div>	<div class=\"comment_status\">closed</div>	<div class=\"ping_status\">open</div>	<div class=\"_status\">publish</div>	<div class=\"jj\">16</div>	<div class=\"mm\">12</div>	<div class=\"aa\">2016</div>	<div class=\"hh\">17</div>	<div class=\"mn\">29</div>	<div class=\"ss\">28</div>	<div class=\"post_password\"></div><div class=\"post_category\" id=\"category_975\">1</div><div class=\"tags_input\" id=\"post_tag_975\"></div><div class=\"sticky\"></div><div class=\"post_format\"></div></div></td>			<td class=\"author column-author\"><a href=\"edit.php?post_type=post&#038;author=59\">José Paulo</a></td>			<td class=\"categories column-categories\"><a href=\"edit.php?category_name=sem-categoria\">Sem categoria</a></td><td class=\"tags column-tags\">&#8212;</td>			<td class=\"comments column-comments\"><div class=\"post-com-count-wrapper\">			<a href='http://jpcontabil.com/wp/wp-admin/edit-comments.php?p=975' title='0 pendente(s)' class='post-com-count'><span class='comment-count'>0</span></a>			</div></td>			<td class=\"date column-date\"><abbr title=\"16/12/2016 17:29:28\">16/12/2016</abbr><br />Publicado</td>		</tr>			<tr id=\"post-973\" class=\"iedit author-other level-0 post-973 type-post status-publish format-standard hentry category-sem-categoria\">				<th scope=\"row\" class=\"check-column\">								<label class=\"screen-reader-text\" for=\"cb-select-973\">Selecionar Cuidado para não ser autuado pela receita federal por sonegação envolvendo distribuição de lucros</label>				<input id=\"cb-select-973\" type=\"checkbox\" name=\"post[]\" value=\"973\" />				<div class=\"locked-indicator\"></div>							</th>			<td class=\"post-title page-title column-title\"><strong><a class=\"row-title\" href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=973&amp;action=edit\" title=\"Editar &#8220;Cuidado para não ser autuado pela receita federal por sonegação envolvendo distribuição de lucros&#8221;\">Cuidado para não ser autuado pela receita federal por sonegação envolvendo distribuição de lucros</a></strong><div class=\"locked-info\"><span class=\"locked-avatar\"></span> <span class=\"locked-text\"></span></div><div class=\"row-actions\"><span class='edit'><a href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=973&amp;action=edit\" title=\"Editar este item\">Editar</a> | </span><span class='inline hide-if-no-js'><a href=\"#\" class=\"editinline\" title=\"Editar este item diretamente\">Edição rápida</a> | </span><span class='trash'><a class='submitdelete' title='Mover este item para a Lixeira' href='http://jpcontabil.com/wp/wp-admin/post.php?post=973&amp;action=trash&amp;_wpnonce=9828002dd6'>Lixeira</a> | </span><span class='view'><a href=\"http://jpcontabil.com/wp/2016/12/16/cuidado-para-nao-ser-autuado-pela-receita-federal-por-sonegacao-envolvendo-distribuicao-de-lucros/\" title=\"Ver &#8220;Cuidado para não ser autuado pela receita federal por sonegação envolvendo distribuição de lucros&#8221;\" rel=\"permalink\">Ver</a></span></div><div class=\"hidden\" id=\"inline_973\">	<div class=\"post_title\">Cuidado para não ser autuado pela receita federal por sonegação envolvendo distribuição de lucros</div>	<div class=\"post_name\">cuidado-para-nao-ser-autuado-pela-receita-federal-por-sonegacao-envolvendo-distribuicao-de-lucros</div>	<div class=\"post_author\">59</div>	<div class=\"comment_status\">closed</div>	<div class=\"ping_status\">open</div>	<div class=\"_status\">publish</div>	<div class=\"jj\">16</div>	<div class=\"mm\">12</div>	<div class=\"aa\">2016</div>	<div class=\"hh\">17</div>	<div class=\"mn\">22</div>	<div class=\"ss\">45</div>	<div class=\"post_password\"></div><div class=\"post_category\" id=\"category_973\">1</div><div class=\"tags_input\" id=\"post_tag_973\"></div><div class=\"sticky\"></div><div class=\"post_format\"></div></div></td>			<td class=\"author column-author\"><a href=\"edit.php?post_type=post&#038;author=59\">José Paulo</a></td>			<td class=\"categories column-categories\"><a href=\"edit.php?category_name=sem-categoria\">Sem categoria</a></td><td class=\"tags column-tags\">&#8212;</td>			<td class=\"comments column-comments\"><div class=\"post-com-count-wrapper\">			<a href='http://jpcontabil.com/wp/wp-admin/edit-comments.php?p=973' title='0 pendente(s)' class='post-com-count'><span class='comment-count'>0</span></a>			</div></td>			<td class=\"date column-date\"><abbr title=\"16/12/2016 17:22:45\">16/12/2016</abbr><br />Publicado</td>		</tr>			<tr id=\"post-971\" class=\"iedit author-other level-0 post-971 type-post status-publish format-standard hentry category-sem-categoria\">				<th scope=\"row\" class=\"check-column\">								<label class=\"screen-reader-text\" for=\"cb-select-971\">Selecionar PE: Portaria altera valores de multas por atraso na entrega de SEFs</label>				<input id=\"cb-select-971\" type=\"checkbox\" name=\"post[]\" value=\"971\" />				<div class=\"locked-indicator\"></div>							</th>			<td class=\"post-title page-title column-title\"><strong><a class=\"row-title\" href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=971&amp;action=edit\" title=\"Editar &#8220;PE: Portaria altera valores de multas por atraso na entrega de SEFs&#8221;\">PE: Portaria altera valores de multas por atraso na entrega de SEFs</a></strong><div class=\"locked-info\"><span class=\"locked-avatar\"></span> <span class=\"locked-text\"></span></div><div class=\"row-actions\"><span class='edit'><a href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=971&amp;action=edit\" title=\"Editar este item\">Editar</a> | </span><span class='inline hide-if-no-js'><a href=\"#\" class=\"editinline\" title=\"Editar este item diretamente\">Edição rápida</a> | </span><span class='trash'><a class='submitdelete' title='Mover este item para a Lixeira' href='http://jpcontabil.com/wp/wp-admin/post.php?post=971&amp;action=trash&amp;_wpnonce=f08c71b055'>Lixeira</a> | </span><span class='view'><a href=\"http://jpcontabil.com/wp/2016/11/14/pe-portaria-altera-valores-de-multas-por-atraso-na-entrega-de-sefs/\" title=\"Ver &#8220;PE: Portaria altera valores de multas por atraso na entrega de SEFs&#8221;\" rel=\"permalink\">Ver</a></span></div><div class=\"hidden\" id=\"inline_971\">	<div class=\"post_title\">PE: Portaria altera valores de multas por atraso na entrega de SEFs</div>	<div class=\"post_name\">pe-portaria-altera-valores-de-multas-por-atraso-na-entrega-de-sefs</div>	<div class=\"post_author\">59</div>	<div class=\"comment_status\">closed</div>	<div class=\"ping_status\">open</div>	<div class=\"_status\">publish</div>	<div class=\"jj\">14</div>	<div class=\"mm\">11</div>	<div class=\"aa\">2016</div>	<div class=\"hh\">17</div>	<div class=\"mn\">28</div>	<div class=\"ss\">52</div>	<div class=\"post_password\"></div><div class=\"post_category\" id=\"category_971\">1</div><div class=\"tags_input\" id=\"post_tag_971\"></div><div class=\"sticky\"></div><div class=\"post_format\"></div></div></td>			<td class=\"author column-author\"><a href=\"edit.php?post_type=post&#038;author=59\">José Paulo</a></td>			<td class=\"categories column-categories\"><a href=\"edit.php?category_name=sem-categoria\">Sem categoria</a></td><td class=\"tags column-tags\">&#8212;</td>			<td class=\"comments column-comments\"><div class=\"post-com-count-wrapper\">			<a href='http://jpcontabil.com/wp/wp-admin/edit-comments.php?p=971' title='0 pendente(s)' class='post-com-count'><span class='comment-count'>0</span></a>			</div></td>			<td class=\"date column-date\"><abbr title=\"14/11/2016 17:28:52\">14/11/2016</abbr><br />Publicado</td>		</tr>			<tr id=\"post-969\" class=\"iedit author-other level-0 post-969 type-post status-publish format-standard hentry category-sem-categoria\">				<th scope=\"row\" class=\"check-column\">								<label class=\"screen-reader-text\" for=\"cb-select-969\">Selecionar Receita Federal inicia exclusão de empresas do Simples Nacional</label>				<input id=\"cb-select-969\" type=\"checkbox\" name=\"post[]\" value=\"969\" />				<div class=\"locked-indicator\"></div>							</th>			<td class=\"post-title page-title column-title\"><strong><a class=\"row-title\" href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=969&amp;action=edit\" title=\"Editar &#8220;Receita Federal inicia exclusão de empresas do Simples Nacional&#8221;\">Receita Federal inicia exclusão de empresas do Simples Nacional</a></strong><div class=\"locked-info\"><span class=\"locked-avatar\"></span> <span class=\"locked-text\"></span></div><div class=\"row-actions\"><span class='edit'><a href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=969&amp;action=edit\" title=\"Editar este item\">Editar</a> | </span><span class='inline hide-if-no-js'><a href=\"#\" class=\"editinline\" title=\"Editar este item diretamente\">Edição rápida</a> | </span><span class='trash'><a class='submitdelete' title='Mover este item para a Lixeira' href='http://jpcontabil.com/wp/wp-admin/post.php?post=969&amp;action=trash&amp;_wpnonce=334924261a'>Lixeira</a> | </span><span class='view'><a href=\"http://jpcontabil.com/wp/2016/11/03/receita-federal-inicia-exclusao-de-empresas-do-simples-nacional/\" title=\"Ver &#8220;Receita Federal inicia exclusão de empresas do Simples Nacional&#8221;\" rel=\"permalink\">Ver</a></span></div><div class=\"hidden\" id=\"inline_969\">	<div class=\"post_title\">Receita Federal inicia exclusão de empresas do Simples Nacional</div>	<div class=\"post_name\">receita-federal-inicia-exclusao-de-empresas-do-simples-nacional</div>	<div class=\"post_author\">59</div>	<div class=\"comment_status\">closed</div>	<div class=\"ping_status\">open</div>	<div class=\"_status\">publish</div>	<div class=\"jj\">03</div>	<div class=\"mm\">11</div>	<div class=\"aa\">2016</div>	<div class=\"hh\">17</div>	<div class=\"mn\">27</div>	<div class=\"ss\">55</div>	<div class=\"post_password\"></div><div class=\"post_category\" id=\"category_969\">1</div><div class=\"tags_input\" id=\"post_tag_969\"></div><div class=\"sticky\"></div><div class=\"post_format\"></div></div></td>			<td class=\"author column-author\"><a href=\"edit.php?post_type=post&#038;author=59\">José Paulo</a></td>			<td class=\"categories column-categories\"><a href=\"edit.php?category_name=sem-categoria\">Sem categoria</a></td><td class=\"tags column-tags\">&#8212;</td>			<td class=\"comments column-comments\"><div class=\"post-com-count-wrapper\">			<a href='http://jpcontabil.com/wp/wp-admin/edit-comments.php?p=969' title='0 pendente(s)' class='post-com-count'><span class='comment-count'>0</span></a>			</div></td>			<td class=\"date column-date\"><abbr title=\"03/11/2016 17:27:55\">03/11/2016</abbr><br />Publicado</td>		</tr>			<tr id=\"post-967\" class=\"iedit author-other level-0 post-967 type-post status-publish format-standard hentry category-sem-categoria\">				<th scope=\"row\" class=\"check-column\">								<label class=\"screen-reader-text\" for=\"cb-select-967\">Selecionar Agendamento Simples Nacional para 2017</label>				<input id=\"cb-select-967\" type=\"checkbox\" name=\"post[]\" value=\"967\" />				<div class=\"locked-indicator\"></div>							</th>			<td class=\"post-title page-title column-title\"><strong><a class=\"row-title\" href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=967&amp;action=edit\" title=\"Editar &#8220;Agendamento Simples Nacional para 2017&#8221;\">Agendamento Simples Nacional para 2017</a></strong><div class=\"locked-info\"><span class=\"locked-avatar\"></span> <span class=\"locked-text\"></span></div><div class=\"row-actions\"><span class='edit'><a href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=967&amp;action=edit\" title=\"Editar este item\">Editar</a> | </span><span class='inline hide-if-no-js'><a href=\"#\" class=\"editinline\" title=\"Editar este item diretamente\">Edição rápida</a> | </span><span class='trash'><a class='submitdelete' title='Mover este item para a Lixeira' href='http://jpcontabil.com/wp/wp-admin/post.php?post=967&amp;action=trash&amp;_wpnonce=77b29ee8d3'>Lixeira</a> | </span><span class='view'><a href=\"http://jpcontabil.com/wp/2016/11/03/agendamento-simples-nacional-para-2017/\" title=\"Ver &#8220;Agendamento Simples Nacional para 2017&#8221;\" rel=\"permalink\">Ver</a></span></div><div class=\"hidden\" id=\"inline_967\">	<div class=\"post_title\">Agendamento Simples Nacional para 2017</div>	<div class=\"post_name\">agendamento-simples-nacional-para-2017</div>	<div class=\"post_author\">59</div>	<div class=\"comment_status\">closed</div>	<div class=\"ping_status\">open</div>	<div class=\"_status\">publish</div>	<div class=\"jj\">03</div>	<div class=\"mm\">11</div>	<div class=\"aa\">2016</div>	<div class=\"hh\">16</div>	<div class=\"mn\">39</div>	<div class=\"ss\">30</div>	<div class=\"post_password\"></div><div class=\"post_category\" id=\"category_967\">1</div><div class=\"tags_input\" id=\"post_tag_967\"></div><div class=\"sticky\"></div><div class=\"post_format\"></div></div></td>			<td class=\"author column-author\"><a href=\"edit.php?post_type=post&#038;author=59\">José Paulo</a></td>			<td class=\"categories column-categories\"><a href=\"edit.php?category_name=sem-categoria\">Sem categoria</a></td><td class=\"tags column-tags\">&#8212;</td>			<td class=\"comments column-comments\"><div class=\"post-com-count-wrapper\">			<a href='http://jpcontabil.com/wp/wp-admin/edit-comments.php?p=967' title='0 pendente(s)' class='post-com-count'><span class='comment-count'>0</span></a>			</div></td>			<td class=\"date column-date\"><abbr title=\"03/11/2016 16:39:30\">03/11/2016</abbr><br />Publicado</td>		</tr>			<tr id=\"post-965\" class=\"iedit author-other level-0 post-965 type-post status-publish format-standard hentry category-sem-categoria\">				<th scope=\"row\" class=\"check-column\">								<label class=\"screen-reader-text\" for=\"cb-select-965\">Selecionar Simples Nacional – Lei Complementar 155/2016 traz novas regras e limites</label>				<input id=\"cb-select-965\" type=\"checkbox\" name=\"post[]\" value=\"965\" />				<div class=\"locked-indicator\"></div>							</th>			<td class=\"post-title page-title column-title\"><strong><a class=\"row-title\" href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=965&amp;action=edit\" title=\"Editar &#8220;Simples Nacional – Lei Complementar 155/2016 traz novas regras e limites&#8221;\">Simples Nacional – Lei Complementar 155/2016 traz novas regras e limites</a></strong><div class=\"locked-info\"><span class=\"locked-avatar\"></span> <span class=\"locked-text\"></span></div><div class=\"row-actions\"><span class='edit'><a href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=965&amp;action=edit\" title=\"Editar este item\">Editar</a> | </span><span class='inline hide-if-no-js'><a href=\"#\" class=\"editinline\" title=\"Editar este item diretamente\">Edição rápida</a> | </span><span class='trash'><a class='submitdelete' title='Mover este item para a Lixeira' href='http://jpcontabil.com/wp/wp-admin/post.php?post=965&amp;action=trash&amp;_wpnonce=60dff49259'>Lixeira</a> | </span><span class='view'><a href=\"http://jpcontabil.com/wp/2016/11/01/simples-nacional-lei-complementar-1552016-traz-novas-regras-e-limites/\" title=\"Ver &#8220;Simples Nacional – Lei Complementar 155/2016 traz novas regras e limites&#8221;\" rel=\"permalink\">Ver</a></span></div><div class=\"hidden\" id=\"inline_965\">	<div class=\"post_title\">Simples Nacional – Lei Complementar 155/2016 traz novas regras e limites</div>	<div class=\"post_name\">simples-nacional-lei-complementar-1552016-traz-novas-regras-e-limites</div>	<div class=\"post_author\">59</div>	<div class=\"comment_status\">closed</div>	<div class=\"ping_status\">open</div>	<div class=\"_status\">publish</div>	<div class=\"jj\">01</div>	<div class=\"mm\">11</div>	<div class=\"aa\">2016</div>	<div class=\"hh\">17</div>	<div class=\"mn\">37</div>	<div class=\"ss\">17</div>	<div class=\"post_password\"></div><div class=\"post_category\" id=\"category_965\">1</div><div class=\"tags_input\" id=\"post_tag_965\"></div><div class=\"sticky\"></div><div class=\"post_format\"></div></div></td>			<td class=\"author column-author\"><a href=\"edit.php?post_type=post&#038;author=59\">José Paulo</a></td>			<td class=\"categories column-categories\"><a href=\"edit.php?category_name=sem-categoria\">Sem categoria</a></td><td class=\"tags column-tags\">&#8212;</td>			<td class=\"comments column-comments\"><div class=\"post-com-count-wrapper\">			<a href='http://jpcontabil.com/wp/wp-admin/edit-comments.php?p=965' title='0 pendente(s)' class='post-com-count'><span class='comment-count'>0</span></a>			</div></td>			<td class=\"date column-date\"><abbr title=\"01/11/2016 17:37:17\">01/11/2016</abbr><br />Publicado</td>		</tr>			<tr id=\"post-961\" class=\"iedit author-other level-0 post-961 type-post status-publish format-standard hentry category-sem-categoria\">				<th scope=\"row\" class=\"check-column\">								<label class=\"screen-reader-text\" for=\"cb-select-961\">Selecionar A autenticação dos livros contábeis digitais com as novas regras do SPED, trazidas pela IN SRF nº 1.660</label>				<input id=\"cb-select-961\" type=\"checkbox\" name=\"post[]\" value=\"961\" />				<div class=\"locked-indicator\"></div>							</th>			<td class=\"post-title page-title column-title\"><strong><a class=\"row-title\" href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=961&amp;action=edit\" title=\"Editar &#8220;A autenticação dos livros contábeis digitais com as novas regras do SPED, trazidas pela IN SRF nº 1.660&#8221;\">A autenticação dos livros contábeis digitais com as novas regras do SPED, trazidas pela IN SRF nº 1.660</a></strong><div class=\"locked-info\"><span class=\"locked-avatar\"></span> <span class=\"locked-text\"></span></div><div class=\"row-actions\"><span class='edit'><a href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=961&amp;action=edit\" title=\"Editar este item\">Editar</a> | </span><span class='inline hide-if-no-js'><a href=\"#\" class=\"editinline\" title=\"Editar este item diretamente\">Edição rápida</a> | </span><span class='trash'><a class='submitdelete' title='Mover este item para a Lixeira' href='http://jpcontabil.com/wp/wp-admin/post.php?post=961&amp;action=trash&amp;_wpnonce=2f52b085df'>Lixeira</a> | </span><span class='view'><a href=\"http://jpcontabil.com/wp/2016/10/31/a-autenticacao-dos-livros-contabeis-digitais-com-as-novas-regras-do-sped-trazidas-pela-in-srf-no-1-660/\" title=\"Ver &#8220;A autenticação dos livros contábeis digitais com as novas regras do SPED, trazidas pela IN SRF nº 1.660&#8221;\" rel=\"permalink\">Ver</a></span></div><div class=\"hidden\" id=\"inline_961\">	<div class=\"post_title\">A autenticação dos livros contábeis digitais com as novas regras do SPED, trazidas pela IN SRF nº 1.660</div>	<div class=\"post_name\">a-autenticacao-dos-livros-contabeis-digitais-com-as-novas-regras-do-sped-trazidas-pela-in-srf-no-1-660</div>	<div class=\"post_author\">59</div>	<div class=\"comment_status\">closed</div>	<div class=\"ping_status\">open</div>	<div class=\"_status\">publish</div>	<div class=\"jj\">31</div>	<div class=\"mm\">10</div>	<div class=\"aa\">2016</div>	<div class=\"hh\">16</div>	<div class=\"mn\">20</div>	<div class=\"ss\">19</div>	<div class=\"post_password\"></div><div class=\"post_category\" id=\"category_961\">1</div><div class=\"tags_input\" id=\"post_tag_961\"></div><div class=\"sticky\"></div><div class=\"post_format\"></div></div></td>			<td class=\"author column-author\"><a href=\"edit.php?post_type=post&#038;author=59\">José Paulo</a></td>			<td class=\"categories column-categories\"><a href=\"edit.php?category_name=sem-categoria\">Sem categoria</a></td><td class=\"tags column-tags\">&#8212;</td>			<td class=\"comments column-comments\"><div class=\"post-com-count-wrapper\">			<a href='http://jpcontabil.com/wp/wp-admin/edit-comments.php?p=961' title='0 pendente(s)' class='post-com-count'><span class='comment-count'>0</span></a>			</div></td>			<td class=\"date column-date\"><abbr title=\"31/10/2016 16:20:19\">31/10/2016</abbr><br />Publicado</td>		</tr>			<tr id=\"post-959\" class=\"iedit author-other level-0 post-959 type-post status-publish format-standard hentry category-sem-categoria\">				<th scope=\"row\" class=\"check-column\">								<label class=\"screen-reader-text\" for=\"cb-select-959\">Selecionar A Contabilidade e o planejamento tributário</label>				<input id=\"cb-select-959\" type=\"checkbox\" name=\"post[]\" value=\"959\" />				<div class=\"locked-indicator\"></div>							</th>			<td class=\"post-title page-title column-title\"><strong><a class=\"row-title\" href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=959&amp;action=edit\" title=\"Editar &#8220;A Contabilidade e o planejamento tributário&#8221;\">A Contabilidade e o planejamento tributário</a></strong><div class=\"locked-info\"><span class=\"locked-avatar\"></span> <span class=\"locked-text\"></span></div><div class=\"row-actions\"><span class='edit'><a href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=959&amp;action=edit\" title=\"Editar este item\">Editar</a> | </span><span class='inline hide-if-no-js'><a href=\"#\" class=\"editinline\" title=\"Editar este item diretamente\">Edição rápida</a> | </span><span class='trash'><a class='submitdelete' title='Mover este item para a Lixeira' href='http://jpcontabil.com/wp/wp-admin/post.php?post=959&amp;action=trash&amp;_wpnonce=14c667890f'>Lixeira</a> | </span><span class='view'><a href=\"http://jpcontabil.com/wp/2016/10/31/a-contabilidade-e-o-planejamento-tributario/\" title=\"Ver &#8220;A Contabilidade e o planejamento tributário&#8221;\" rel=\"permalink\">Ver</a></span></div><div class=\"hidden\" id=\"inline_959\">	<div class=\"post_title\">A Contabilidade e o planejamento tributário</div>	<div class=\"post_name\">a-contabilidade-e-o-planejamento-tributario</div>	<div class=\"post_author\">59</div>	<div class=\"comment_status\">closed</div>	<div class=\"ping_status\">open</div>	<div class=\"_status\">publish</div>	<div class=\"jj\">31</div>	<div class=\"mm\">10</div>	<div class=\"aa\">2016</div>	<div class=\"hh\">12</div>	<div class=\"mn\">18</div>	<div class=\"ss\">24</div>	<div class=\"post_password\"></div><div class=\"post_category\" id=\"category_959\">1</div><div class=\"tags_input\" id=\"post_tag_959\"></div><div class=\"sticky\"></div><div class=\"post_format\"></div></div></td>			<td class=\"author column-author\"><a href=\"edit.php?post_type=post&#038;author=59\">José Paulo</a></td>			<td class=\"categories column-categories\"><a href=\"edit.php?category_name=sem-categoria\">Sem categoria</a></td><td class=\"tags column-tags\">&#8212;</td>			<td class=\"comments column-comments\"><div class=\"post-com-count-wrapper\">			<a href='http://jpcontabil.com/wp/wp-admin/edit-comments.php?p=959' title='0 pendente(s)' class='post-com-count'><span class='comment-count'>0</span></a>			</div></td>			<td class=\"date column-date\"><abbr title=\"31/10/2016 12:18:24\">31/10/2016</abbr><br />Publicado</td>		</tr>			<tr id=\"post-957\" class=\"iedit author-other level-0 post-957 type-post status-publish format-standard hentry category-sem-categoria\">				<th scope=\"row\" class=\"check-column\">								<label class=\"screen-reader-text\" for=\"cb-select-957\">Selecionar Sefaz-PE divulga programa de recuperação de créditos tributários</label>				<input id=\"cb-select-957\" type=\"checkbox\" name=\"post[]\" value=\"957\" />				<div class=\"locked-indicator\"></div>							</th>			<td class=\"post-title page-title column-title\"><strong><a class=\"row-title\" href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=957&amp;action=edit\" title=\"Editar &#8220;Sefaz-PE divulga programa de recuperação de créditos tributários&#8221;\">Sefaz-PE divulga programa de recuperação de créditos tributários</a></strong><div class=\"locked-info\"><span class=\"locked-avatar\"></span> <span class=\"locked-text\"></span></div><div class=\"row-actions\"><span class='edit'><a href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=957&amp;action=edit\" title=\"Editar este item\">Editar</a> | </span><span class='inline hide-if-no-js'><a href=\"#\" class=\"editinline\" title=\"Editar este item diretamente\">Edição rápida</a> | </span><span class='trash'><a class='submitdelete' title='Mover este item para a Lixeira' href='http://jpcontabil.com/wp/wp-admin/post.php?post=957&amp;action=trash&amp;_wpnonce=9fbc7ae3d9'>Lixeira</a> | </span><span class='view'><a href=\"http://jpcontabil.com/wp/2016/10/27/sefaz-pe-divulga-programa-de-recuperacao-de-creditos-tributarios/\" title=\"Ver &#8220;Sefaz-PE divulga programa de recuperação de créditos tributários&#8221;\" rel=\"permalink\">Ver</a></span></div><div class=\"hidden\" id=\"inline_957\">	<div class=\"post_title\">Sefaz-PE divulga programa de recuperação de créditos tributários</div>	<div class=\"post_name\">sefaz-pe-divulga-programa-de-recuperacao-de-creditos-tributarios</div>	<div class=\"post_author\">59</div>	<div class=\"comment_status\">closed</div>	<div class=\"ping_status\">open</div>	<div class=\"_status\">publish</div>	<div class=\"jj\">27</div>	<div class=\"mm\">10</div>	<div class=\"aa\">2016</div>	<div class=\"hh\">16</div>	<div class=\"mn\">26</div>	<div class=\"ss\">21</div>	<div class=\"post_password\"></div><div class=\"post_category\" id=\"category_957\">1</div><div class=\"tags_input\" id=\"post_tag_957\"></div><div class=\"sticky\"></div><div class=\"post_format\"></div></div></td>			<td class=\"author column-author\"><a href=\"edit.php?post_type=post&#038;author=59\">José Paulo</a></td>			<td class=\"categories column-categories\"><a href=\"edit.php?category_name=sem-categoria\">Sem categoria</a></td><td class=\"tags column-tags\">&#8212;</td>			<td class=\"comments column-comments\"><div class=\"post-com-count-wrapper\">			<a href='http://jpcontabil.com/wp/wp-admin/edit-comments.php?p=957' title='0 pendente(s)' class='post-com-count'><span class='comment-count'>0</span></a>			</div></td>			<td class=\"date column-date\"><abbr title=\"27/10/2016 16:26:21\">27/10/2016</abbr><br />Publicado</td>		</tr>			<tr id=\"post-955\" class=\"iedit author-other level-0 post-955 type-post status-publish format-standard hentry category-sem-categoria\">				<th scope=\"row\" class=\"check-column\">								<label class=\"screen-reader-text\" for=\"cb-select-955\">Selecionar Temer sanciona Crescer sem Medo &#8211; Programa Nacional de Microcrédito</label>				<input id=\"cb-select-955\" type=\"checkbox\" name=\"post[]\" value=\"955\" />				<div class=\"locked-indicator\"></div>							</th>			<td class=\"post-title page-title column-title\"><strong><a class=\"row-title\" href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=955&amp;action=edit\" title=\"Editar &#8220;Temer sanciona Crescer sem Medo &#8211; Programa Nacional de Microcrédito&#8221;\">Temer sanciona Crescer sem Medo &#8211; Programa Nacional de Microcrédito</a></strong><div class=\"locked-info\"><span class=\"locked-avatar\"></span> <span class=\"locked-text\"></span></div><div class=\"row-actions\"><span class='edit'><a href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=955&amp;action=edit\" title=\"Editar este item\">Editar</a> | </span><span class='inline hide-if-no-js'><a href=\"#\" class=\"editinline\" title=\"Editar este item diretamente\">Edição rápida</a> | </span><span class='trash'><a class='submitdelete' title='Mover este item para a Lixeira' href='http://jpcontabil.com/wp/wp-admin/post.php?post=955&amp;action=trash&amp;_wpnonce=85c3dfc0b9'>Lixeira</a> | </span><span class='view'><a href=\"http://jpcontabil.com/wp/2016/10/27/temer-sanciona-crescer-sem-medo-programa-nacional-de-microcredito/\" title=\"Ver &#8220;Temer sanciona Crescer sem Medo &#8211; Programa Nacional de Microcrédito&#8221;\" rel=\"permalink\">Ver</a></span></div><div class=\"hidden\" id=\"inline_955\">	<div class=\"post_title\">Temer sanciona Crescer sem Medo - Programa Nacional de Microcrédito</div>	<div class=\"post_name\">temer-sanciona-crescer-sem-medo-programa-nacional-de-microcredito</div>	<div class=\"post_author\">59</div>	<div class=\"comment_status\">closed</div>	<div class=\"ping_status\">open</div>	<div class=\"_status\">publish</div>	<div class=\"jj\">27</div>	<div class=\"mm\">10</div>	<div class=\"aa\">2016</div>	<div class=\"hh\">10</div>	<div class=\"mn\">29</div>	<div class=\"ss\">10</div>	<div class=\"post_password\"></div><div class=\"post_category\" id=\"category_955\">1</div><div class=\"tags_input\" id=\"post_tag_955\"></div><div class=\"sticky\"></div><div class=\"post_format\"></div></div></td>			<td class=\"author column-author\"><a href=\"edit.php?post_type=post&#038;author=59\">José Paulo</a></td>			<td class=\"categories column-categories\"><a href=\"edit.php?category_name=sem-categoria\">Sem categoria</a></td><td class=\"tags column-tags\">&#8212;</td>			<td class=\"comments column-comments\"><div class=\"post-com-count-wrapper\">			<a href='http://jpcontabil.com/wp/wp-admin/edit-comments.php?p=955' title='0 pendente(s)' class='post-com-count'><span class='comment-count'>0</span></a>			</div></td>			<td class=\"date column-date\"><abbr title=\"27/10/2016 10:29:10\">27/10/2016</abbr><br />Publicado</td>		</tr>			<tr id=\"post-953\" class=\"iedit author-other level-0 post-953 type-post status-publish format-standard hentry category-sem-categoria\">				<th scope=\"row\" class=\"check-column\">								<label class=\"screen-reader-text\" for=\"cb-select-953\">Selecionar Mesmo com parcelamento de débitos ampliado, milhares de empresas podem deixar o Simples</label>				<input id=\"cb-select-953\" type=\"checkbox\" name=\"post[]\" value=\"953\" />				<div class=\"locked-indicator\"></div>							</th>			<td class=\"post-title page-title column-title\"><strong><a class=\"row-title\" href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=953&amp;action=edit\" title=\"Editar &#8220;Mesmo com parcelamento de débitos ampliado, milhares de empresas podem deixar o Simples&#8221;\">Mesmo com parcelamento de débitos ampliado, milhares de empresas podem deixar o Simples</a></strong><div class=\"locked-info\"><span class=\"locked-avatar\"></span> <span class=\"locked-text\"></span></div><div class=\"row-actions\"><span class='edit'><a href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=953&amp;action=edit\" title=\"Editar este item\">Editar</a> | </span><span class='inline hide-if-no-js'><a href=\"#\" class=\"editinline\" title=\"Editar este item diretamente\">Edição rápida</a> | </span><span class='trash'><a class='submitdelete' title='Mover este item para a Lixeira' href='http://jpcontabil.com/wp/wp-admin/post.php?post=953&amp;action=trash&amp;_wpnonce=10f746e902'>Lixeira</a> | </span><span class='view'><a href=\"http://jpcontabil.com/wp/2016/10/25/mesmo-com-parcelamento-de-debitos-ampliado-milhares-de-empresas-podem-deixar-o-simples/\" title=\"Ver &#8220;Mesmo com parcelamento de débitos ampliado, milhares de empresas podem deixar o Simples&#8221;\" rel=\"permalink\">Ver</a></span></div><div class=\"hidden\" id=\"inline_953\">	<div class=\"post_title\">Mesmo com parcelamento de débitos ampliado, milhares de empresas podem deixar o Simples</div>	<div class=\"post_name\">mesmo-com-parcelamento-de-debitos-ampliado-milhares-de-empresas-podem-deixar-o-simples</div>	<div class=\"post_author\">59</div>	<div class=\"comment_status\">closed</div>	<div class=\"ping_status\">open</div>	<div class=\"_status\">publish</div>	<div class=\"jj\">25</div>	<div class=\"mm\">10</div>	<div class=\"aa\">2016</div>	<div class=\"hh\">16</div>	<div class=\"mn\">01</div>	<div class=\"ss\">38</div>	<div class=\"post_password\"></div><div class=\"post_category\" id=\"category_953\">1</div><div class=\"tags_input\" id=\"post_tag_953\"></div><div class=\"sticky\"></div><div class=\"post_format\"></div></div></td>			<td class=\"author column-author\"><a href=\"edit.php?post_type=post&#038;author=59\">José Paulo</a></td>			<td class=\"categories column-categories\"><a href=\"edit.php?category_name=sem-categoria\">Sem categoria</a></td><td class=\"tags column-tags\">&#8212;</td>			<td class=\"comments column-comments\"><div class=\"post-com-count-wrapper\">			<a href='http://jpcontabil.com/wp/wp-admin/edit-comments.php?p=953' title='0 pendente(s)' class='post-com-count'><span class='comment-count'>0</span></a>			</div></td>			<td class=\"date column-date\"><abbr title=\"25/10/2016 16:01:38\">25/10/2016</abbr><br />Publicado</td>		</tr>			<tr id=\"post-951\" class=\"iedit author-other level-0 post-951 type-post status-publish format-standard hentry category-sem-categoria\">				<th scope=\"row\" class=\"check-column\">								<label class=\"screen-reader-text\" for=\"cb-select-951\">Selecionar Substituição Tributária &#8211; Optantes pelo Simples Nacional</label>				<input id=\"cb-select-951\" type=\"checkbox\" name=\"post[]\" value=\"951\" />				<div class=\"locked-indicator\"></div>							</th>			<td class=\"post-title page-title column-title\"><strong><a class=\"row-title\" href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=951&amp;action=edit\" title=\"Editar &#8220;Substituição Tributária &#8211; Optantes pelo Simples Nacional&#8221;\">Substituição Tributária &#8211; Optantes pelo Simples Nacional</a></strong><div class=\"locked-info\"><span class=\"locked-avatar\"></span> <span class=\"locked-text\"></span></div><div class=\"row-actions\"><span class='edit'><a href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=951&amp;action=edit\" title=\"Editar este item\">Editar</a> | </span><span class='inline hide-if-no-js'><a href=\"#\" class=\"editinline\" title=\"Editar este item diretamente\">Edição rápida</a> | </span><span class='trash'><a class='submitdelete' title='Mover este item para a Lixeira' href='http://jpcontabil.com/wp/wp-admin/post.php?post=951&amp;action=trash&amp;_wpnonce=9d7a48a30a'>Lixeira</a> | </span><span class='view'><a href=\"http://jpcontabil.com/wp/2016/10/21/substituicao-tributaria-optantes-pelo-simples-nacional/\" title=\"Ver &#8220;Substituição Tributária &#8211; Optantes pelo Simples Nacional&#8221;\" rel=\"permalink\">Ver</a></span></div><div class=\"hidden\" id=\"inline_951\">	<div class=\"post_title\">Substituição Tributária - Optantes pelo Simples Nacional</div>	<div class=\"post_name\">substituicao-tributaria-optantes-pelo-simples-nacional</div>	<div class=\"post_author\">59</div>	<div class=\"comment_status\">closed</div>	<div class=\"ping_status\">open</div>	<div class=\"_status\">publish</div>	<div class=\"jj\">21</div>	<div class=\"mm\">10</div>	<div class=\"aa\">2016</div>	<div class=\"hh\">09</div>	<div class=\"mn\">53</div>	<div class=\"ss\">31</div>	<div class=\"post_password\"></div><div class=\"post_category\" id=\"category_951\">1</div><div class=\"tags_input\" id=\"post_tag_951\"></div><div class=\"sticky\"></div><div class=\"post_format\"></div></div></td>			<td class=\"author column-author\"><a href=\"edit.php?post_type=post&#038;author=59\">José Paulo</a></td>			<td class=\"categories column-categories\"><a href=\"edit.php?category_name=sem-categoria\">Sem categoria</a></td><td class=\"tags column-tags\">&#8212;</td>			<td class=\"comments column-comments\"><div class=\"post-com-count-wrapper\">			<a href='http://jpcontabil.com/wp/wp-admin/edit-comments.php?p=951' title='0 pendente(s)' class='post-com-count'><span class='comment-count'>0</span></a>			</div></td>			<td class=\"date column-date\"><abbr title=\"21/10/2016 9:53:31\">21/10/2016</abbr><br />Publicado</td>		</tr>			<tr id=\"post-946\" class=\"iedit author-other level-0 post-946 type-post status-publish format-standard hentry category-sem-categoria\">				<th scope=\"row\" class=\"check-column\">								<label class=\"screen-reader-text\" for=\"cb-select-946\">Selecionar • Terceirização ou contratação CLT? Entenda as diferenças pelas leis trabalhistas</label>				<input id=\"cb-select-946\" type=\"checkbox\" name=\"post[]\" value=\"946\" />				<div class=\"locked-indicator\"></div>							</th>			<td class=\"post-title page-title column-title\"><strong><a class=\"row-title\" href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=946&amp;action=edit\" title=\"Editar &#8220;• Terceirização ou contratação CLT? Entenda as diferenças pelas leis trabalhistas&#8221;\">• Terceirização ou contratação CLT? Entenda as diferenças pelas leis trabalhistas</a></strong><div class=\"locked-info\"><span class=\"locked-avatar\"></span> <span class=\"locked-text\"></span></div><div class=\"row-actions\"><span class='edit'><a href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=946&amp;action=edit\" title=\"Editar este item\">Editar</a> | </span><span class='inline hide-if-no-js'><a href=\"#\" class=\"editinline\" title=\"Editar este item diretamente\">Edição rápida</a> | </span><span class='trash'><a class='submitdelete' title='Mover este item para a Lixeira' href='http://jpcontabil.com/wp/wp-admin/post.php?post=946&amp;action=trash&amp;_wpnonce=bf3b7ca53e'>Lixeira</a> | </span><span class='view'><a href=\"http://jpcontabil.com/wp/2016/10/20/terceirizacao-ou-contratacao-clt-entenda-as-diferencas-pelas-leis-trabalhistas/\" title=\"Ver &#8220;• Terceirização ou contratação CLT? Entenda as diferenças pelas leis trabalhistas&#8221;\" rel=\"permalink\">Ver</a></span></div><div class=\"hidden\" id=\"inline_946\">	<div class=\"post_title\">• Terceirização ou contratação CLT? Entenda as diferenças pelas leis trabalhistas</div>	<div class=\"post_name\">terceirizacao-ou-contratacao-clt-entenda-as-diferencas-pelas-leis-trabalhistas</div>	<div class=\"post_author\">59</div>	<div class=\"comment_status\">closed</div>	<div class=\"ping_status\">open</div>	<div class=\"_status\">publish</div>	<div class=\"jj\">20</div>	<div class=\"mm\">10</div>	<div class=\"aa\">2016</div>	<div class=\"hh\">16</div>	<div class=\"mn\">07</div>	<div class=\"ss\">51</div>	<div class=\"post_password\"></div><div class=\"post_category\" id=\"category_946\">1</div><div class=\"tags_input\" id=\"post_tag_946\"></div><div class=\"sticky\"></div><div class=\"post_format\"></div></div></td>			<td class=\"author column-author\"><a href=\"edit.php?post_type=post&#038;author=59\">José Paulo</a></td>			<td class=\"categories column-categories\"><a href=\"edit.php?category_name=sem-categoria\">Sem categoria</a></td><td class=\"tags column-tags\">&#8212;</td>			<td class=\"comments column-comments\"><div class=\"post-com-count-wrapper\">			<a href='http://jpcontabil.com/wp/wp-admin/edit-comments.php?p=946' title='0 pendente(s)' class='post-com-count'><span class='comment-count'>0</span></a>			</div></td>			<td class=\"date column-date\"><abbr title=\"20/10/2016 16:07:51\">20/10/2016</abbr><br />Publicado</td>		</tr>			<tr id=\"post-944\" class=\"iedit author-other level-0 post-944 type-post status-publish format-standard hentry category-sem-categoria\">				<th scope=\"row\" class=\"check-column\">								<label class=\"screen-reader-text\" for=\"cb-select-944\">Selecionar • Contabilidade é uma das áreas que terá maiores ganhos salariais em 2017</label>				<input id=\"cb-select-944\" type=\"checkbox\" name=\"post[]\" value=\"944\" />				<div class=\"locked-indicator\"></div>							</th>			<td class=\"post-title page-title column-title\"><strong><a class=\"row-title\" href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=944&amp;action=edit\" title=\"Editar &#8220;• Contabilidade é uma das áreas que terá maiores ganhos salariais em 2017&#8221;\">• Contabilidade é uma das áreas que terá maiores ganhos salariais em 2017</a></strong><div class=\"locked-info\"><span class=\"locked-avatar\"></span> <span class=\"locked-text\"></span></div><div class=\"row-actions\"><span class='edit'><a href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=944&amp;action=edit\" title=\"Editar este item\">Editar</a> | </span><span class='inline hide-if-no-js'><a href=\"#\" class=\"editinline\" title=\"Editar este item diretamente\">Edição rápida</a> | </span><span class='trash'><a class='submitdelete' title='Mover este item para a Lixeira' href='http://jpcontabil.com/wp/wp-admin/post.php?post=944&amp;action=trash&amp;_wpnonce=2bdc159edb'>Lixeira</a> | </span><span class='view'><a href=\"http://jpcontabil.com/wp/2016/10/20/contabilidade-e-uma-das-areas-que-tera-maiores-ganhos-salariais-em-2017/\" title=\"Ver &#8220;• Contabilidade é uma das áreas que terá maiores ganhos salariais em 2017&#8221;\" rel=\"permalink\">Ver</a></span></div><div class=\"hidden\" id=\"inline_944\">	<div class=\"post_title\">• Contabilidade é uma das áreas que terá maiores ganhos salariais em 2017</div>	<div class=\"post_name\">contabilidade-e-uma-das-areas-que-tera-maiores-ganhos-salariais-em-2017</div>	<div class=\"post_author\">59</div>	<div class=\"comment_status\">closed</div>	<div class=\"ping_status\">open</div>	<div class=\"_status\">publish</div>	<div class=\"jj\">20</div>	<div class=\"mm\">10</div>	<div class=\"aa\">2016</div>	<div class=\"hh\">15</div>	<div class=\"mn\">56</div>	<div class=\"ss\">05</div>	<div class=\"post_password\"></div><div class=\"post_category\" id=\"category_944\">1</div><div class=\"tags_input\" id=\"post_tag_944\"></div><div class=\"sticky\"></div><div class=\"post_format\"></div></div></td>			<td class=\"author column-author\"><a href=\"edit.php?post_type=post&#038;author=59\">José Paulo</a></td>			<td class=\"categories column-categories\"><a href=\"edit.php?category_name=sem-categoria\">Sem categoria</a></td><td class=\"tags column-tags\">&#8212;</td>			<td class=\"comments column-comments\"><div class=\"post-com-count-wrapper\">			<a href='http://jpcontabil.com/wp/wp-admin/edit-comments.php?p=944' title='0 pendente(s)' class='post-com-count'><span class='comment-count'>0</span></a>			</div></td>			<td class=\"date column-date\"><abbr title=\"20/10/2016 15:56:05\">20/10/2016</abbr><br />Publicado</td>		</tr>			<tr id=\"post-927\" class=\"iedit author-other level-0 post-927 type-post status-publish format-standard hentry category-sem-categoria\">				<th scope=\"row\" class=\"check-column\">								<label class=\"screen-reader-text\" for=\"cb-select-927\">Selecionar • Volume de serviços cai 4,7% nos primeiros oito meses ano</label>				<input id=\"cb-select-927\" type=\"checkbox\" name=\"post[]\" value=\"927\" />				<div class=\"locked-indicator\"></div>							</th>			<td class=\"post-title page-title column-title\"><strong><a class=\"row-title\" href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=927&amp;action=edit\" title=\"Editar &#8220;• Volume de serviços cai 4,7% nos primeiros oito meses ano&#8221;\">• Volume de serviços cai 4,7% nos primeiros oito meses ano</a></strong><div class=\"locked-info\"><span class=\"locked-avatar\"></span> <span class=\"locked-text\"></span></div><div class=\"row-actions\"><span class='edit'><a href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=927&amp;action=edit\" title=\"Editar este item\">Editar</a> | </span><span class='inline hide-if-no-js'><a href=\"#\" class=\"editinline\" title=\"Editar este item diretamente\">Edição rápida</a> | </span><span class='trash'><a class='submitdelete' title='Mover este item para a Lixeira' href='http://jpcontabil.com/wp/wp-admin/post.php?post=927&amp;action=trash&amp;_wpnonce=b80cc48280'>Lixeira</a> | </span><span class='view'><a href=\"http://jpcontabil.com/wp/2016/10/19/volume-de-servicos-cai-47-nos-primeiros-oito-meses-ano/\" title=\"Ver &#8220;• Volume de serviços cai 4,7% nos primeiros oito meses ano&#8221;\" rel=\"permalink\">Ver</a></span></div><div class=\"hidden\" id=\"inline_927\">	<div class=\"post_title\">• Volume de serviços cai 4,7% nos primeiros oito meses ano</div>	<div class=\"post_name\">volume-de-servicos-cai-47-nos-primeiros-oito-meses-ano</div>	<div class=\"post_author\">59</div>	<div class=\"comment_status\">closed</div>	<div class=\"ping_status\">open</div>	<div class=\"_status\">publish</div>	<div class=\"jj\">19</div>	<div class=\"mm\">10</div>	<div class=\"aa\">2016</div>	<div class=\"hh\">15</div>	<div class=\"mn\">55</div>	<div class=\"ss\">27</div>	<div class=\"post_password\"></div><div class=\"post_category\" id=\"category_927\">1</div><div class=\"tags_input\" id=\"post_tag_927\"></div><div class=\"sticky\"></div><div class=\"post_format\"></div></div></td>			<td class=\"author column-author\"><a href=\"edit.php?post_type=post&#038;author=59\">José Paulo</a></td>			<td class=\"categories column-categories\"><a href=\"edit.php?category_name=sem-categoria\">Sem categoria</a></td><td class=\"tags column-tags\">&#8212;</td>			<td class=\"comments column-comments\"><div class=\"post-com-count-wrapper\">			<a href='http://jpcontabil.com/wp/wp-admin/edit-comments.php?p=927' title='0 pendente(s)' class='post-com-count'><span class='comment-count'>0</span></a>			</div></td>			<td class=\"date column-date\"><abbr title=\"19/10/2016 15:55:27\">19/10/2016</abbr><br />Publicado</td>		</tr>			<tr id=\"post-919\" class=\"iedit author-self level-0 post-919 type-post status-publish format-standard hentry category-sem-categoria\">				<th scope=\"row\" class=\"check-column\">								<label class=\"screen-reader-text\" for=\"cb-select-919\">Selecionar • Simples Nacional – Câmara aprova ampliação do Limite e prazo para parcelamento</label>				<input id=\"cb-select-919\" type=\"checkbox\" name=\"post[]\" value=\"919\" />				<div class=\"locked-indicator\"></div>							</th>			<td class=\"post-title page-title column-title\"><strong><a class=\"row-title\" href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=919&amp;action=edit\" title=\"Editar &#8220;• Simples Nacional – Câmara aprova ampliação do Limite e prazo para parcelamento&#8221;\">• Simples Nacional – Câmara aprova ampliação do Limite e prazo para parcelamento</a></strong><div class=\"locked-info\"><span class=\"locked-avatar\"></span> <span class=\"locked-text\"></span></div><div class=\"row-actions\"><span class='edit'><a href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=919&amp;action=edit\" title=\"Editar este item\">Editar</a> | </span><span class='inline hide-if-no-js'><a href=\"#\" class=\"editinline\" title=\"Editar este item diretamente\">Edição rápida</a> | </span><span class='trash'><a class='submitdelete' title='Mover este item para a Lixeira' href='http://jpcontabil.com/wp/wp-admin/post.php?post=919&amp;action=trash&amp;_wpnonce=6b5f72e6c1'>Lixeira</a> | </span><span class='view'><a href=\"http://jpcontabil.com/wp/2016/10/14/%e2%80%a2-simples-nacional-camara-aprova-ampliacao-do-limite-e-prazo-para-parcelamento/\" title=\"Ver &#8220;• Simples Nacional – Câmara aprova ampliação do Limite e prazo para parcelamento&#8221;\" rel=\"permalink\">Ver</a></span></div><div class=\"hidden\" id=\"inline_919\">	<div class=\"post_title\">• Simples Nacional – Câmara aprova ampliação do Limite e prazo para parcelamento</div>	<div class=\"post_name\">•-simples-nacional-camara-aprova-ampliacao-do-limite-e-prazo-para-parcelamento</div>	<div class=\"post_author\">1</div>	<div class=\"comment_status\">closed</div>	<div class=\"ping_status\">open</div>	<div class=\"_status\">publish</div>	<div class=\"jj\">14</div>	<div class=\"mm\">10</div>	<div class=\"aa\">2016</div>	<div class=\"hh\">08</div>	<div class=\"mn\">32</div>	<div class=\"ss\">51</div>	<div class=\"post_password\"></div><div class=\"post_category\" id=\"category_919\">1</div><div class=\"tags_input\" id=\"post_tag_919\"></div><div class=\"sticky\"></div><div class=\"post_format\"></div></div></td>			<td class=\"author column-author\"><a href=\"edit.php?post_type=post&#038;author=1\">pmateus</a></td>			<td class=\"categories column-categories\"><a href=\"edit.php?category_name=sem-categoria\">Sem categoria</a></td><td class=\"tags column-tags\">&#8212;</td>			<td class=\"comments column-comments\"><div class=\"post-com-count-wrapper\">			<a href='http://jpcontabil.com/wp/wp-admin/edit-comments.php?p=919' title='0 pendente(s)' class='post-com-count'><span class='comment-count'>0</span></a>			</div></td>			<td class=\"date column-date\"><abbr title=\"14/10/2016 8:32:51\">14/10/2016</abbr><br />Publicado</td>		</tr>			<tr id=\"post-915\" class=\"iedit author-self level-0 post-915 type-post status-publish format-standard hentry category-sem-categoria\">				<th scope=\"row\" class=\"check-column\">								<label class=\"screen-reader-text\" for=\"cb-select-915\">Selecionar • Saiba por que a licença paternidade de 20 dias não vale para todos</label>				<input id=\"cb-select-915\" type=\"checkbox\" name=\"post[]\" value=\"915\" />				<div class=\"locked-indicator\"></div>							</th>			<td class=\"post-title page-title column-title\"><strong><a class=\"row-title\" href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=915&amp;action=edit\" title=\"Editar &#8220;• Saiba por que a licença paternidade de 20 dias não vale para todos&#8221;\">• Saiba por que a licença paternidade de 20 dias não vale para todos</a></strong><div class=\"locked-info\"><span class=\"locked-avatar\"></span> <span class=\"locked-text\"></span></div><div class=\"row-actions\"><span class='edit'><a href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=915&amp;action=edit\" title=\"Editar este item\">Editar</a> | </span><span class='inline hide-if-no-js'><a href=\"#\" class=\"editinline\" title=\"Editar este item diretamente\">Edição rápida</a> | </span><span class='trash'><a class='submitdelete' title='Mover este item para a Lixeira' href='http://jpcontabil.com/wp/wp-admin/post.php?post=915&amp;action=trash&amp;_wpnonce=9499b04dca'>Lixeira</a> | </span><span class='view'><a href=\"http://jpcontabil.com/wp/2016/10/06/%e2%80%a2-saiba-por-que-a-licenca-paternidade-de-20-dias-nao-vale-para-todos/\" title=\"Ver &#8220;• Saiba por que a licença paternidade de 20 dias não vale para todos&#8221;\" rel=\"permalink\">Ver</a></span></div><div class=\"hidden\" id=\"inline_915\">	<div class=\"post_title\">• Saiba por que a licença paternidade de 20 dias não vale para todos</div>	<div class=\"post_name\">•-saiba-por-que-a-licenca-paternidade-de-20-dias-nao-vale-para-todos</div>	<div class=\"post_author\">1</div>	<div class=\"comment_status\">closed</div>	<div class=\"ping_status\">open</div>	<div class=\"_status\">publish</div>	<div class=\"jj\">06</div>	<div class=\"mm\">10</div>	<div class=\"aa\">2016</div>	<div class=\"hh\">08</div>	<div class=\"mn\">39</div>	<div class=\"ss\">45</div>	<div class=\"post_password\"></div><div class=\"post_category\" id=\"category_915\">1</div><div class=\"tags_input\" id=\"post_tag_915\"></div><div class=\"sticky\"></div><div class=\"post_format\"></div></div></td>			<td class=\"author column-author\"><a href=\"edit.php?post_type=post&#038;author=1\">pmateus</a></td>			<td class=\"categories column-categories\"><a href=\"edit.php?category_name=sem-categoria\">Sem categoria</a></td><td class=\"tags column-tags\">&#8212;</td>			<td class=\"comments column-comments\"><div class=\"post-com-count-wrapper\">			<a href='http://jpcontabil.com/wp/wp-admin/edit-comments.php?p=915' title='0 pendente(s)' class='post-com-count'><span class='comment-count'>0</span></a>			</div></td>			<td class=\"date column-date\"><abbr title=\"06/10/2016 8:39:45\">06/10/2016</abbr><br />Publicado</td>		</tr>			<tr id=\"post-909\" class=\"iedit author-other level-0 post-909 type-post status-draft format-standard hentry category-sem-categoria tag-parcelamento tag-sefaz\">				<th scope=\"row\" class=\"check-column\">								<label class=\"screen-reader-text\" for=\"cb-select-909\">Selecionar • Sefaz-PE divulga programa de recuperação de créditos tributários</label>				<input id=\"cb-select-909\" type=\"checkbox\" name=\"post[]\" value=\"909\" />				<div class=\"locked-indicator\"></div>							</th>			<td class=\"post-title page-title column-title\"><strong><a class=\"row-title\" href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=909&amp;action=edit\" title=\"Editar &#8220;• Sefaz-PE divulga programa de recuperação de créditos tributários&#8221;\">• Sefaz-PE divulga programa de recuperação de créditos tributários</a> - <span class='post-state'>Rascunho</span></strong><div class=\"locked-info\"><span class=\"locked-avatar\"></span> <span class=\"locked-text\"></span></div><div class=\"row-actions\"><span class='edit'><a href=\"http://jpcontabil.com/wp/wp-admin/post.php?post=909&amp;action=edit\" title=\"Editar este item\">Editar</a> | </span><span class='inline hide-if-no-js'><a href=\"#\" class=\"editinline\" title=\"Editar este item diretamente\">Edição rápida</a> | </span><span class='trash'><a class='submitdelete' title='Mover este item para a Lixeira' href='http://jpcontabil.com/wp/wp-admin/post.php?post=909&amp;action=trash&amp;_wpnonce=296a715e8f'>Lixeira</a> | </span><span class='view'><a href=\"http://jpcontabil.com/wp/?p=909&#038;preview=true\" title=\"Visualizar &#8220;• Sefaz-PE divulga programa de recuperação de créditos tributários&#8221;\" rel=\"permalink\">Visualizar</a></span></div><div class=\"hidden\" id=\"inline_909\">	<div class=\"post_title\">• Sefaz-PE divulga programa de recuperação de créditos tributários</div>	<div class=\"post_name\"></div>	<div class=\"post_author\">58</div>	<div class=\"comment_status\">closed</div>	<div class=\"ping_status\">open</div>	<div class=\"_status\">draft</div>	<div class=\"jj\">05</div>	<div class=\"mm\">10</div>	<div class=\"aa\">2016</div>	<div class=\"hh\">17</div>	<div class=\"mn\">40</div>	<div class=\"ss\">09</div>	<div class=\"post_password\"></div><div class=\"post_category\" id=\"category_909\">1</div><div class=\"tags_input\" id=\"post_tag_909\">parcelamento, sefaz</div><div class=\"sticky\"></div><div class=\"post_format\"></div></div></td>			<td class=\"author column-author\"><a href=\"edit.php?post_type=post&#038;author=58\">Morgana Paulete</a></td>			<td class=\"categories column-categories\"><a href=\"edit.php?category_name=sem-categoria\">Sem categoria</a></td><td class=\"tags column-tags\"><a href=\"edit.php?tag=parcelamento\">parcelamento</a>, <a href=\"edit.php?tag=sefaz\">sefaz</a></td>			<td class=\"comments column-comments\"><div class=\"post-com-count-wrapper\">			<a href='http://jpcontabil.com/wp/wp-admin/edit-comments.php?p=909' title='0 pendente(s)' class='post-com-count'><span class='comment-count'>0</span></a>			</div></td>			<td class=\"date column-date\"><abbr title=\"05/10/2016 17:40:09\">05/10/2016</abbr><br />Modificado pela última vez</td>		</tr>		</tbody>	<tfoot>	<tr>		<th scope='col'  class='manage-column column-cb check-column'  style=\"\"><label class=\"screen-reader-text\" for=\"cb-select-all-2\">Selecionar todos</label><input id=\"cb-select-all-2\" type=\"checkbox\" /></th><th scope='col'  class='manage-column column-title sortable desc'  style=\"\"><a href=\"http://jpcontabil.com/wp/wp-admin/edit.php?orderby=title&#038;order=asc\"><span>Título</span><span class=\"sorting-indicator\"></span></a></th><th scope='col'  class='manage-column column-author'  style=\"\">Autor</th><th scope='col'  class='manage-column column-categories'  style=\"\">Categorias</th><th scope='col'  class='manage-column column-tags'  style=\"\">Tags</th><th scope='col'  class='manage-column column-comments num sortable desc'  style=\"\"><a href=\"http://jpcontabil.com/wp/wp-admin/edit.php?orderby=comment_count&#038;order=asc\"><span><span class=\"vers comment-grey-bubble\" title=\"Comentários\"><span class=\"screen-reader-text\">Comentários</span></span></span><span class=\"sorting-indicator\"></span></a></th><th scope='col'  class='manage-column column-date sortable asc'  style=\"\"><a href=\"http://jpcontabil.com/wp/wp-admin/edit.php?orderby=date&#038;order=desc\"><span>Data</span><span class=\"sorting-indicator\"></span></a></th>	</tr>	</tfoot></table>	<div class=\"tablenav bottom\">		<div class=\"alignleft actions bulkactions\">			<label for='bulk-action-selector-bottom' class='screen-reader-text'>Selecionar ação em massa</label><select name='action2' id='bulk-action-selector-bottom'><option value='-1' selected='selected'>Ações em massa</option>	<option value='edit' class=\"hide-if-no-js\">Editar</option>	<option value='trash'>Mover para a lixeira</option></select><input type=\"submit\" id=\"doaction2\" class=\"button action\" value=\"Aplicar\"  />		</div>		<div class=\"alignleft actions\">		</div><div class='tablenav-pages'><span class=\"displaying-num\">99 itens</span><span class='pagination-links'><a class='first-page disabled' title='Ir para a primeira página' href='http://jpcontabil.com/wp/wp-admin/edit.php'>&laquo;</a><a class='prev-page disabled' title='Ir para a página anterior' href='http://jpcontabil.com/wp/wp-admin/edit.php?paged=1'>&lsaquo;</a><span class=\"paging-input\">1 de <span class='total-pages'>5</span></span><a class='next-page' title='Ir para a próxima página' href='http://jpcontabil.com/wp/wp-admin/edit.php?paged=2'>&rsaquo;</a><a class='last-page' title='Ir para a última página' href='http://jpcontabil.com/wp/wp-admin/edit.php?paged=5'>&raquo;</a></span></div>		<br class=\"clear\" />	</div></form>	<form method=\"get\"><table style=\"display: none\"><tbody id=\"inlineedit\">				<tr id=\"inline-edit\" class=\"inline-edit-row inline-edit-row-post inline-edit-post quick-edit-row quick-edit-row-post inline-edit-post\" style=\"display: none\"><td colspan=\"7\" class=\"colspanchange\">		<fieldset class=\"inline-edit-col-left\"><div class=\"inline-edit-col\">			<h4>Edição rápida</h4>				<label>				<span class=\"title\">Título</span>				<span class=\"input-text-wrap\"><input type=\"text\" name=\"post_title\" class=\"ptitle\" value=\"\" /></span>			</label>			<label>				<span class=\"title\">Slug</span>				<span class=\"input-text-wrap\"><input type=\"text\" name=\"post_name\" value=\"\" /></span>			</label>					<label><span class=\"title\">Data</span></label>			<div class=\"inline-edit-date\">				<div class=\"timestamp-wrap\"><label for=\"mm\" class=\"screen-reader-text\">Mês</label><select name=\"mm\">			<option value=\"01\"  selected='selected'>01-jan</option>			<option value=\"02\" >02-fev</option>			<option value=\"03\" >03-mar</option>			<option value=\"04\" >04-abr</option>			<option value=\"05\" >05-mai</option>			<option value=\"06\" >06-jun</option>			<option value=\"07\" >07-jul</option>			<option value=\"08\" >08-ago</option>			<option value=\"09\" >09-set</option>			<option value=\"10\" >10-out</option>			<option value=\"11\" >11-nov</option>			<option value=\"12\" >12-dez</option></select> <label for=\"jj\" class=\"screen-reader-text\">Dia</label><input type=\"text\" name=\"jj\" value=\"13\" size=\"2\" maxlength=\"2\" autocomplete=\"off\" />, <label for=\"aa\" class=\"screen-reader-text\">Ano</label><input type=\"text\" name=\"aa\" value=\"2017\" size=\"4\" maxlength=\"4\" autocomplete=\"off\" /> às <label for=\"hh\" class=\"screen-reader-text\">Hora</label><input type=\"text\" name=\"hh\" value=\"12\" size=\"2\" maxlength=\"2\" autocomplete=\"off\" />: <label for=\"mn\" class=\"screen-reader-text\">Minuto</label><input type=\"text\" name=\"mn\" value=\"06\" size=\"2\" maxlength=\"2\" autocomplete=\"off\" /></div><input type=\"hidden\" id=\"ss\" name=\"ss\" value=\"19\" />			</div>			<br class=\"clear\" />		<label class=\"inline-edit-author\"><span class=\"title\">Autor</span><select name='post_author' class='authors'>	<option value='59'>José Paulo</option>	<option value='58'>Morgana Paulete</option>	<option value='1'>pmateus</option></select></label>			<div class=\"inline-edit-group\">				<label class=\"alignleft\">					<span class=\"title\">Senha</span>					<span class=\"input-text-wrap\"><input type=\"text\" name=\"post_password\" class=\"inline-edit-password-input\" value=\"\" /></span>				</label>				<em class=\"alignleft inline-edit-or\">					&ndash;OU&ndash;				</em>				<label class=\"alignleft inline-edit-private\">					<input type=\"checkbox\" name=\"keep_private\" value=\"private\" />					<span class=\"checkbox-title\">Privado</span>				</label>			</div>			</div></fieldset>			<fieldset class=\"inline-edit-col-center inline-edit-categories\"><div class=\"inline-edit-col\">				<span class=\"title inline-edit-categories-label\">Categorias</span>			<input type=\"hidden\" name=\"post_category[]\" value=\"0\" />			<ul class=\"cat-checklist category-checklist\">				<li id='category-1' class=\"popular-category\"><label class=\"selectit\"><input value=\"1\" type=\"checkbox\" name=\"post_category[]\" id=\"in-category-1\" /> Sem categoria</label></li>			</ul>			</div></fieldset>			<fieldset class=\"inline-edit-col-right\"><div class=\"inline-edit-col\">								<label class=\"inline-edit-tags\">				<span class=\"title\">Tags</span>				<textarea cols=\"22\" rows=\"1\" name=\"tax_input[post_tag]\" class=\"tax_input_post_tag\"></textarea>			</label>								<div class=\"inline-edit-group\">							<label class=\"alignleft\">					<input type=\"checkbox\" name=\"comment_status\" value=\"open\" />					<span class=\"checkbox-title\">Permitir comentários</span>				</label>							<label class=\"alignleft\">					<input type=\"checkbox\" name=\"ping_status\" value=\"open\" />					<span class=\"checkbox-title\">Permitir pings</span>				</label>						</div>				<div class=\"inline-edit-group\">				<label class=\"inline-edit-status alignleft\">					<span class=\"title\">Status</span>					<select name=\"_status\">												<option value=\"publish\">Publicado</option>						<option value=\"future\">Agendado</option>												<option value=\"pending\">Revisão pendente</option>						<option value=\"draft\">Rascunho</option>					</select>				</label>						<label class=\"alignleft\">					<input type=\"checkbox\" name=\"sticky\" value=\"sticky\" />					<span class=\"checkbox-title\">Fixar este post</span>				</label>					</div>			</div></fieldset>			<p class=\"submit inline-edit-save\">			<a href=\"#inline-edit\" class=\"button-secondary cancel alignleft\">Cancelar</a>			<input type=\"hidden\" id=\"_inline_edit\" name=\"_inline_edit\" value=\"f01f9b67ab\" />				<a href=\"#inline-edit\" class=\"button-primary save alignright\">Atualizar</a>				<span class=\"spinner\"></span>						<input type=\"hidden\" name=\"post_view\" value=\"list\" />			<input type=\"hidden\" name=\"screen\" value=\"edit-post\" />						<span class=\"error\" style=\"display:none\"></span>			<br class=\"clear\" />		</p>		</td></tr>			<tr id=\"bulk-edit\" class=\"inline-edit-row inline-edit-row-post inline-edit-post bulk-edit-row bulk-edit-row-post bulk-edit-post\" style=\"display: none\"><td colspan=\"7\" class=\"colspanchange\">		<fieldset class=\"inline-edit-col-left\"><div class=\"inline-edit-col\">			<h4>Edição em massa</h4>				<div id=\"bulk-title-div\">				<div id=\"bulk-titles\"></div>			</div>					</div></fieldset>			<fieldset class=\"inline-edit-col-right\"><div class=\"inline-edit-col\">	<label class=\"inline-edit-author\"><span class=\"title\">Autor</span><select name='post_author' class='authors'>	<option value='-1'>&mdash; Nenhuma mudança &mdash;</option>	<option value='59'>José Paulo</option>	<option value='58'>Morgana Paulete</option>	<option value='1'>pmateus</option></select></label>					<div class=\"inline-edit-group\">					<label class=\"alignleft\">				<span class=\"title\">Comentários</span>				<select name=\"comment_status\">					<option value=\"\">&mdash; Nenhuma mudança &mdash;</option>					<option value=\"open\">Permitir</option>					<option value=\"closed\">Não permitir</option>				</select>			</label>					<label class=\"alignright\">				<span class=\"title\">Pings</span>				<select name=\"ping_status\">					<option value=\"\">&mdash; Nenhuma mudança &mdash;</option>					<option value=\"open\">Permitir</option>					<option value=\"closed\">Não permitir</option>				</select>			</label>					</div>				<div class=\"inline-edit-group\">				<label class=\"inline-edit-status alignleft\">					<span class=\"title\">Status</span>					<select name=\"_status\">							<option value=\"-1\">&mdash; Nenhuma mudança &mdash;</option>												<option value=\"publish\">Publicado</option>						<option value=\"future\">Agendado</option>							<option value=\"private\">Privado</option>												<option value=\"pending\">Revisão pendente</option>						<option value=\"draft\">Rascunho</option>					</select>				</label>						<label class=\"alignright\">					<span class=\"title\">Fixo</span>					<select name=\"sticky\">						<option value=\"-1\">&mdash; Nenhuma mudança &mdash;</option>						<option value=\"sticky\">Fixo</option>						<option value=\"unsticky\">Não fixo</option>					</select>				</label>					</div>			<label class=\"alignleft\" for=\"post_format\">		<span class=\"title\">Formato</span>		<select name=\"post_format\">			<option value=\"-1\">&mdash; Nenhuma mudança &mdash;</option>			<option value=\"0\">Padrão</option>							<option value=\"aside\">Nota</option>								<option value=\"image\">Imagem</option>								<option value=\"link\">Link</option>								<option value=\"quote\">Citação</option>								<option value=\"status\">Status</option>						</select></label>			</div></fieldset>			<p class=\"submit inline-edit-save\">			<a href=\"#inline-edit\" class=\"button-secondary cancel alignleft\">Cancelar</a>			<input type=\"submit\" name=\"bulk_edit\" id=\"bulk_edit\" class=\"button button-primary alignright\" value=\"Atualizar\"  />			<input type=\"hidden\" name=\"post_view\" value=\"list\" />			<input type=\"hidden\" name=\"screen\" value=\"edit-post\" />						<span class=\"error\" style=\"display:none\"></span>			<br class=\"clear\" />		</p>		</td></tr>			</tbody></table></form><div id=\"ajax-response\"></div><br class=\"clear\" /></div><div class=\"clear\"></div></div><!-- wpbody-content --><div class=\"clear\"></div></div><!-- wpbody --><div class=\"clear\"></div></div><!-- wpcontent --><div id=\"wpfooter\" role=\"contentinfo\">		<p id=\"footer-left\" class=\"alignleft\">		JP Contábil & Filhos - Nome forte em assessoria	</p>	<p id=\"footer-upgrade\" class=\"alignright\">		<strong><a href=\"http://jpcontabil.com/wp/wp-admin/update-core.php\">Pegar a versão 4.9.5</a></strong>	</p>	<div class=\"clear\"></div></div>	<div id=\"wp-auth-check-wrap\" class=\"hidden\">	<div id=\"wp-auth-check-bg\"></div>	<div id=\"wp-auth-check\">	<div class=\"wp-auth-check-close\" tabindex=\"0\" title=\"Fechar\"></div>			<div id=\"wp-auth-check-form\" data-src=\"http://jpcontabil.com/wp/wp-login.php?interim-login=1\"></div>			<div class=\"wp-auth-fallback\">		<p><b class=\"wp-auth-fallback-expired\" tabindex=\"0\">A sessão expirou</b></p>		<p><a href=\"http://jpcontabil.com/wp/wp-login.php\" target=\"_blank\">Faça login novamente.</a>		A página de login será aberta em uma nova janela. Depois de fazer o login, você pode fechá-la e voltar a esta página.</p>	</div>	</div>	</div>	<link rel='stylesheet' id='wpcom-notes-admin-bar-css'  href='http://s0.wp.com/wp-content/mu-plugins/notes/admin-bar-v2.css?ver=3.6.1-201814' type='text/css' media='all' /><link rel='stylesheet' id='noticons-css'  href='http://s0.wp.com/i/noticons/noticons.css?ver=3.6.1-201814' type='text/css' media='all' /><script type='text/javascript'>/* <![CDATA[ */var commonL10n = {\"warnDelete\":\"Voc\\u00ea est\\u00e1 prestes a excluir permanentemente os itens selecionados.\\n  'Cancelar' para interromper, 'OK' para excluir.\",\"dismiss\":\"Dispensar este aviso.\"};var inlineEditL10n = {\"error\":\"Erro ao salvar altera\\u00e7\\u00f5es.\",\"ntdeltitle\":\"Remover da Edi\\u00e7\\u00e3o em Massa\",\"notitle\":\"(sem t\\u00edtulo)\",\"comma\":\",\"};var heartbeatSettings = {\"nonce\":\"da4ec84381\"};var authcheckL10n = {\"beforeunload\":\"A sua sess\\u00e3o expirou. Voc\\u00ea pode fazer o login novamente aqui ou ir para a p\\u00e1gina de login.\",\"interval\":\"180\"};/* ]]> */</script><script type='text/javascript' src='http://jpcontabil.com/wp/wp-admin/load-scripts.php?c=1&amp;load%5B%5D=hoverIntent,common,admin-bar,suggest,inline-edit-post,heartbeat,svg-painter,wp-auth-check,underscore,backbone&amp;ver=4.2.20'></script><script type='text/javascript' src='http://s0.wp.com/wp-content/js/devicepx-jetpack.js?ver=201814'></script><script type='text/javascript' src='http://s1.wp.com/wp-content/js/mustache.js?ver=3.6.1-201814'></script><script type='text/javascript' src='http://s1.wp.com/wp-content/mu-plugins/notes/notes-common-v2.js?ver=3.6.1-201814'></script><script type='text/javascript' src='http://s0.wp.com/wp-content/mu-plugins/notes/admin-bar-v2.js?ver=3.6.1-201814'></script><div class=\"clear\"></div></div><!-- wpwrap --><script type=\"text/javascript\">if(typeof wpOnload=='function')wpOnload();</script></body></html>";
		txt = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n" + 
				"<meta http-equiv=\"X-UA-Compatible\" content=\"IE=EDGE,chrome=1\" />\r\n" + 
				"<html lang=\"pt-br\">\r\n" + 
				"<head>\r\n" + 
				"<script type=\"text/javascript\" src=\"/cfscripts/cfform.js\">\r\n" + 
				"</script>\r\n" + 
				"<script type=\"text/javascript\" src=\"/cfscripts/masks.js\">\r\n" + 
				"</script>\r\n" + 
				"<meta http-equiv=\"X-UA-Compatible\" content=\"IE=EDGE,chrome=1\" />\r\n" + 
				"<meta http-equiv=\"Content-Language\" Content=\"pt\">\r\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n" + 
				"<title>\r\n" + 
				"resultadoBuscaCepEndereco\r\n" + 
				"</title>\r\n" + 
				"<meta name=\"description\" content=\"[page]\" />\r\n" + 
				"<meta name=\"keywords\" content=\"\" />\r\n" + 
				"<!-- AppInternalsXpert BMX Integration Begin -->\r\n" + 
				"<script>\r\n" + 
				"if(!RVBD_EUE){   var RVBD_EUE={startJS:Number(new Date()),   clientId:'',appId:1,   collector:'apmperformance.correios.com.br',   collectorHttpPort:80, collectorHttpsPort:443,   sv:'0401',   ajax:true, sync:true,   ajaxResponseTime:true};   (function(){      var w=window,l=w.addEventListener,m=w.attachEvent,      d=document,s='script',t='load',o=RVBD_EUE,      r=(('https:'===d.location.protocol)?      'https://apmperformance.correios.com.br:443':      'http://apmperformance.correios.com.br:80')+      '/jsi/riverbed_appinternals.d.'+      (o.ajax?'ajax.js':'js'),p=('onpagehide' in w),e=p?'pageshow':t,      j=d.createElement(s),x=d.getElementsByTagName(s)[0],      h=function(y){o.ldJS=o.ldJS||new Date();o.per=y?y.persisted:null;},      i=function(){o.ld=1;};o.cookie=d.cookie;d.cookie=      '_op_aixPageId=0; path=/; expires='+(new Date(0)).toGMTString();      o.cookieAfterDelete=d.cookie;j.async=1;j.src=r;      if(l){l(e,h,false);if(p){l(t,i,false);}}else if(m)      {m('on'+e,h);if(p){m('on'+t,i);}}      if(o.sync){d.write('\r\n" + 
				"<'+s+' src=\\''+r+'\\'>\r\n" + 
				"</'+s+'>\r\n" + 
				"');}      else{x.parentNode.insertBefore(j,x);}   })();}\r\n" + 
				"</script>\r\n" + 
				"<script>\r\n" + 
				"if(!RVBD_EUE_PARAM){var RVBD_EUE_PARAM={};} RVBD_EUE_PARAM.pageId = 'a2_8aac2c65-fead-4270-96cc-0e445f5fab8d';\r\n" + 
				"</script>\r\n" + 
				"             \r\n" + 
				"<!-- AppInternalsXpert BMX Integration End -->\r\n" + 
				"<script type=\"text/javascript\">\r\n" + 
				" pageid = 'B7A1CE69-03C5-E340-A7A58A0F9F301DD7'; \r\n" + 
				"</script>\r\n" + 
				"<noscript>\r\n" + 
				"<p>\r\n" + 
				"identificador da p&Atilde;¡gina\r\n" + 
				"</p>\r\n" + 
				"</noscript>\r\n" + 
				"<base href=\"http://www.buscacep.correios.com.br/\">\r\n" + 
				"<link rel=\"icon\" href=\"home2014/img/icon.png\" type=\"image/gif\"/>\r\n" + 
				"<!-- scripts -->\r\n" + 
				"<noscript>\r\n" + 
				"<p>\r\n" + 
				"Biblioteca de efeitos\r\n" + 
				"</p>\r\n" + 
				"</noscript>\r\n" + 
				"   \r\n" + 
				"<script type=\"text/javascript\" src=\"home2014/js/jquery-1.6.2.min.js\">\r\n" + 
				"</script>\r\n" + 
				"    \r\n" + 
				"<noscript>\r\n" + 
				"<p>\r\n" + 
				"Biblioteca de efeitos para menus\r\n" + 
				"</p>\r\n" + 
				"</noscript>\r\n" + 
				"   \r\n" + 
				"<script type=\"text/javascript\" src=\"home2014/js/ddaccordion.js\">\r\n" + 
				"</script>\r\n" + 
				"    \r\n" + 
				"<noscript>\r\n" + 
				"<p>\r\n" + 
				"Biblioteca de efeitos para tabbes\r\n" + 
				"</p>\r\n" + 
				"</noscript>\r\n" + 
				"   \r\n" + 
				"<script type=\"text/javascript\" src=\"home2014/js/jtabber.js\">\r\n" + 
				"</script>\r\n" + 
				"    \r\n" + 
				"<noscript>\r\n" + 
				"<p>\r\n" + 
				"Biblioteca de efeitos colorbox\r\n" + 
				"</p>\r\n" + 
				"</noscript>\r\n" + 
				"   \r\n" + 
				"<script type=\"text/javascript\" src=\"home2014/js/jquery.colorbox-min.js\">\r\n" + 
				"</script>\r\n" + 
				"   \r\n" + 
				"<noscript>\r\n" + 
				"<p>\r\n" + 
				"Biblioteca de validação de formulários\r\n" + 
				"</p>\r\n" + 
				"</noscript>\r\n" + 
				"   \r\n" + 
				"<script type=\"text/javascript\" src=\"home2014/js/validations.js\">\r\n" + 
				"</script>\r\n" + 
				"  \r\n" + 
				"<noscript>\r\n" + 
				"<p>\r\n" + 
				"Script Javascript\r\n" + 
				"</p>\r\n" + 
				"</noscript>\r\n" + 
				"  \r\n" + 
				"<script type=\"text/javascript\" src=\"home2014/js/scripts.js\">\r\n" + 
				"</script>\r\n" + 
				"  \r\n" + 
				"<noscript>\r\n" + 
				"<p>\r\n" + 
				"Script Javascript\r\n" + 
				"</p>\r\n" + 
				"</noscript>\r\n" + 
				"     \r\n" + 
				"<script type=\"text/javascript\" src=\"home2014/js/cookie.js\">\r\n" + 
				"</script>\r\n" + 
				"    \r\n" + 
				"<noscript>\r\n" + 
				"<p>\r\n" + 
				"</p>\r\n" + 
				"Script Javascript\r\n" + 
				"</noscript>\r\n" + 
				"   \r\n" + 
				"<script type=\"text/javascript\">\r\n" + 
				"document.documentElement.className += \" js\";\r\n" + 
				"</script>\r\n" + 
				"  \r\n" + 
				"<noscript>\r\n" + 
				"<p>\r\n" + 
				"Controle de abas\r\n" + 
				"</p>\r\n" + 
				"</noscript>\r\n" + 
				" \r\n" + 
				"<noscript>\r\n" + 
				"<p>\r\n" + 
				"Biblioteca de animações\r\n" + 
				"</p>\r\n" + 
				"</noscript>\r\n" + 
				"   \r\n" + 
				"<script type=\"text/javascript\" src=\"home2014/js/jquery-ui-1.8.16.custom.min.js\">\r\n" + 
				"  \r\n" + 
				"</script>\r\n" + 
				"     \r\n" + 
				"<script type=\"text/javascript\">\r\n" + 
				"   jQuery(function($){        $.datepicker.regional['pt-BR'] = {                closeText: 'Fechar',                prevText: '&#x3c;Anterior',                nextText: 'Pr&oacute;ximo&#x3e;',                currentText: 'Hoje',                monthNames: ['Janeiro','Fevereiro','Mar&ccedil;o','Abril','Maio','Junho',                'Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],                monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun',                'Jul','Ago','Set','Out','Nov','Dez'],                dayNames: ['Domingo','Segunda-feira','Ter&ccedil;a-feira','Quarta-feira','Quinta-feira','Sexta-feira','Sabado'],                dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sab'],                dayNamesMin: ['Dom','Seg','Ter','Qua','Qui','Sex','Sab'],                weekHeader: 'Sm',                dateFormat: 'dd/mm/yy',                firstDay: 0,                isRTL: false,                showMonthAfterYear: false,                yearSuffix: ''};        $.datepicker.setDefaults($.datepicker.regional['pt-BR']);});\r\n" + 
				"</script>\r\n" + 
				"      \r\n" + 
				"<!-- /scripts -->\r\n" + 
				"<!-- CSS -->\r\n" + 
				"  \r\n" + 
				"<link href=\"home2014/css/layout.css\"	rel=\"stylesheet\"	type=\"text/css\" />\r\n" + 
				"<!-- /CSS --->\r\n" + 
				" \r\n" + 
				"<script type=\"text/javascript\">\r\n" + 
				"<!--    _CF_checkGeral = function(_CF_this)    {        //reset on submit        _CF_error_exists = false;        _CF_error_messages = new Array();        _CF_error_fields = new Object();        _CF_FirstErrorField = null;        //display error messages and return success        if( _CF_error_exists )        {            if( _CF_error_messages.length >\r\n" + 
				" 0 )            {                // show alert() message                _CF_onErrorAlert(_CF_error_messages);                // set focus to first form error, if the field supports js focus().                if( _CF_this[_CF_FirstErrorField].type == \"text\" )                { _CF_this[_CF_FirstErrorField].focus(); }            }            return false;        }else {            return true;        }    }//-->\r\n" + 
				"</script>\r\n" + 
				"</head>\r\n" + 
				"<!--[if lt IE 7]>\r\n" + 
				" \r\n" + 
				"<body class=\"ie6\">\r\n" + 
				" \r\n" + 
				"<![endif]-->\r\n" + 
				"<!--[if IE 7]>\r\n" + 
				"    \r\n" + 
				"<body class=\"ie7\">\r\n" + 
				" \r\n" + 
				"<![endif]-->\r\n" + 
				"<!--[if IE 8]>\r\n" + 
				"    \r\n" + 
				"<body class=\"ie8\">\r\n" + 
				" \r\n" + 
				"<![endif]-->\r\n" + 
				"<!--[if !IE]>\r\n" + 
				"-->\r\n" + 
				"  \r\n" + 
				"<body>\r\n" + 
				"             \r\n" + 
				"<!--\r\n" + 
				"<![endif]-->\r\n" + 
				"<div class=\"back\">\r\n" + 
				"<div class=\"acessibilidade\">\r\n" + 
				"  \r\n" + 
				"<div class=\"wrap\">\r\n" + 
				"    \r\n" + 
				"<ul>\r\n" + 
				"              \r\n" + 
				"<li class=\"tocontent\">\r\n" + 
				" \r\n" + 
				"<span class=\"separator-bar\">\r\n" + 
				"&nbsp;\r\n" + 
				"</span>\r\n" + 
				" \r\n" + 
				"<a href=\"javascript:void(0);\" onClick=\"document.location.hash='ancora';\" title=\"Ir para o conte&uacute;do principal da p&aacute;gina\">\r\n" + 
				"Ir ao  conte&uacute;do\r\n" + 
				"</a>\r\n" + 
				" \r\n" + 
				"</li>\r\n" + 
				"        \r\n" + 
				"<li class=\"font-plus\" id=\"biggerFont\">\r\n" + 
				" \r\n" + 
				"<a href=\"javascript:void(0);\" title=\"Aumentar o tamanho da fonte do texto\">\r\n" + 
				"A\r\n" + 
				"</a>\r\n" + 
				" \r\n" + 
				"</li>\r\n" + 
				"        \r\n" + 
				"<li id=\"defaultFont\">\r\n" + 
				" \r\n" + 
				"<span class=\"separator-dot\">\r\n" + 
				"&nbsp;\r\n" + 
				"</span>\r\n" + 
				" \r\n" + 
				"<a href=\"javascript:void(0);\" title=\"Retornar a fonte do texto para tamanho padr&atilde;o\">\r\n" + 
				"Tamanho padr&atilde;o\r\n" + 
				"</a>\r\n" + 
				" \r\n" + 
				"<span class=\"separator-dot\">\r\n" + 
				"&nbsp;\r\n" + 
				"</span>\r\n" + 
				" \r\n" + 
				"</li>\r\n" + 
				"        \r\n" + 
				"<li class=\"font-minus\" id=\"smallerFont\">\r\n" + 
				" \r\n" + 
				"<a href=\"javascript:void(0);\" title=\"Diminuir o tamanho da fonte do texto\">\r\n" + 
				"A\r\n" + 
				"</a>\r\n" + 
				" \r\n" + 
				"</li>\r\n" + 
				"        \r\n" + 
				"<li class=\"contrast\" id=\"contrast\">\r\n" + 
				" \r\n" + 
				"<span class=\"separator-bar\">\r\n" + 
				"&nbsp;\r\n" + 
				"</span>\r\n" + 
				" \r\n" + 
				"<a href=\"javascript:void(0);\" title=\"Modificar para o modo de alto contraste\">\r\n" + 
				"Contraste\r\n" + 
				"</a>\r\n" + 
				" \r\n" + 
				"<span class=\"separator-bar\">\r\n" + 
				"&nbsp;\r\n" + 
				"</span>\r\n" + 
				" \r\n" + 
				"</li>\r\n" + 
				"        \r\n" + 
				"<li>\r\n" + 
				" \r\n" + 
				"<span class=\"separator-bar\">\r\n" + 
				"&nbsp;\r\n" + 
				"</span>\r\n" + 
				" \r\n" + 
				"<a href=\"http://www.correios.com.br/sobre-correios/sustentabilidade/vertente-social/headmouse-e-teclado-virtual/\">\r\n" + 
				"Teclado Virtual\r\n" + 
				"</a>\r\n" + 
				" \r\n" + 
				"</li>\r\n" + 
				"        \r\n" + 
				"<li>\r\n" + 
				" \r\n" + 
				"<a href=\"http://www.correios.com.br/sobre-correios/sustentabilidade/vertente-social/headmouse-e-teclado-virtual/\" id=\"txt-headmouse\">\r\n" + 
				"Headmouse\r\n" + 
				"</a>\r\n" + 
				"</li>\r\n" + 
				"            \r\n" + 
				"</ul>\r\n" + 
				"  \r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				" \r\n" + 
				"<!-- header --->\r\n" + 
				"<div class=\"header\">\r\n" + 
				"<h1 class=\"logo float-left\">\r\n" + 
				" \r\n" + 
				"<a href=\"http://www.correios.com.br\" title=\"Ir para a página incial\" alt=\"Logo Correios\">\r\n" + 
				"<img src=\"home2014/img/layout/logo.png\" alt=\"Ir para a página inicial\" title=\"Ir para a página incial\"/>\r\n" + 
				"</a>\r\n" + 
				" \r\n" + 
				"</h1>\r\n" + 
				"<div class=\"acesso_rapido\">\r\n" + 
				"  \r\n" + 
				"<div class=\"text-right\">\r\n" + 
				"        \r\n" + 
				"<a href=\"http://www.correios.com.br/sobre-correios/fale-com-os-correios/fc\">\r\n" + 
				"Fale com os Correios\r\n" + 
				"</a>\r\n" + 
				"<br/>\r\n" + 
				"  \r\n" + 
				"</div>\r\n" + 
				"  \r\n" + 
				"<div class=\"produtosaz float-right\">\r\n" + 
				"    \r\n" + 
				"<div class=\"expo\">\r\n" + 
				"Outros sites\r\n" + 
				"</div>\r\n" + 
				"    \r\n" + 
				"<span class=\"dados abaaz\">\r\n" + 
				"    \r\n" + 
				"<div class=\"dadosaz\">\r\n" + 
				" \r\n" + 
				"<span class=\"dica\">\r\n" + 
				" Acesse a outros sites dos Correios\r\n" + 
				"</span>\r\n" + 
				"<br/>\r\n" + 
				"      \r\n" + 
				"<a href=\"http://www.correios.com.br/para-voce\">\r\n" + 
				"<b>\r\n" + 
				"Correios para você\r\n" + 
				"</b>\r\n" + 
				"</a>\r\n" + 
				"<br/>\r\n" + 
				"      \r\n" + 
				"<a href=\"http://www.correios.com.br/para-sua-empresa\">\r\n" + 
				"<b>\r\n" + 
				"Correios para sua empresa\r\n" + 
				"</b>\r\n" + 
				"</a>\r\n" + 
				"<br/>\r\n" + 
				"      \r\n" + 
				"<a href=\"http://www.correios.com.br/sobre-correios\">\r\n" + 
				"<b>\r\n" + 
				"Sobre Correios\r\n" + 
				"</b>\r\n" + 
				"</a>\r\n" + 
				"<br/>\r\n" + 
				"      \r\n" + 
				"<a href=\"produtosaz/default.cfm?filtro=R/Z\">\r\n" + 
				"<b>\r\n" + 
				"Espaço da Filatelia\r\n" + 
				"</b>\r\n" + 
				"</a>\r\n" + 
				"<br/>\r\n" + 
				"      \r\n" + 
				"<a href=\"http://blog.correios.com.br/correios\">\r\n" + 
				"<b>\r\n" + 
				"Blog Institucional do Correios\r\n" + 
				"</b>\r\n" + 
				"</a>\r\n" + 
				"<br/>\r\n" + 
				"      \r\n" + 
				"<a href=\"http://m.correios.com.br\">\r\n" + 
				"<b>\r\n" + 
				"Correios mobile\r\n" + 
				"</b>\r\n" + 
				"</a>\r\n" + 
				"<br/>\r\n" + 
				"    \r\n" + 
				"</div>\r\n" + 
				"    \r\n" + 
				"</span>\r\n" + 
				" \r\n" + 
				"</div>\r\n" + 
				"  \r\n" + 
				"<div class=\"produtosaz float-right\">\r\n" + 
				"    \r\n" + 
				"<div class=\"expo\" >\r\n" + 
				"Correios de A a Z\r\n" + 
				"</div>\r\n" + 
				"    \r\n" + 
				"<span class=\"dados abaaz\">\r\n" + 
				"    \r\n" + 
				"<div class=\"dadosaz\">\r\n" + 
				" \r\n" + 
				"<span class=\"dica\">\r\n" + 
				" Escolha pela letra inicial dos nossos produtos, serviços e assuntos.\r\n" + 
				"<br/>\r\n" + 
				"      \r\n" + 
				"</span>\r\n" + 
				"<br/>\r\n" + 
				"      \r\n" + 
				"<a href=\"http://www.correios.com.br/para-voce/correios-de-a-a-z-1\">\r\n" + 
				"<b>\r\n" + 
				"Todos os itens\r\n" + 
				"</b>\r\n" + 
				"</a>\r\n" + 
				"<br/>\r\n" + 
				"      \r\n" + 
				"<a href=\"http://www.correios.com.br/para-voce/correios-de-a-a-z?filtro=abc\">\r\n" + 
				"<b>\r\n" + 
				"Correios de A-C\r\n" + 
				"</b>\r\n" + 
				"</a>\r\n" + 
				"<br/>\r\n" + 
				"      \r\n" + 
				"<a href=\"http://www.correios.com.br/para-voce/correios-de-a-a-z-1?filtro=def\">\r\n" + 
				"<b>\r\n" + 
				"Correios de D-F\r\n" + 
				"</b>\r\n" + 
				"</a>\r\n" + 
				"<br/>\r\n" + 
				"      \r\n" + 
				"<a href=\"http://www.correios.com.br/para-voce/correios-de-a-a-z-1?filtro=ghijklmnopq\">\r\n" + 
				"<b>\r\n" + 
				"Correios de G-Q\r\n" + 
				"</b>\r\n" + 
				"</a>\r\n" + 
				"<br/>\r\n" + 
				"      \r\n" + 
				"<a href=\"http://www.correios.com.br/para-voce/correios-de-a-a-z-1?filtro=rstuvwxyz\">\r\n" + 
				"<b>\r\n" + 
				"Correios de R-Z\r\n" + 
				"</b>\r\n" + 
				"</a>\r\n" + 
				" \r\n" + 
				"</div>\r\n" + 
				"    \r\n" + 
				"</span>\r\n" + 
				" \r\n" + 
				"</div>\r\n" + 
				"  \r\n" + 
				"</div>\r\n" + 
				"  \r\n" + 
				"<!-- acesso rápido -->\r\n" + 
				"  \r\n" + 
				"<br class=\"clr\"/>\r\n" + 
				"  \r\n" + 
				"</div>\r\n" + 
				"  \r\n" + 
				"<div class=\"tabs\">\r\n" + 
				"    \r\n" + 
				"<div class=\"wrap\">\r\n" + 
				"    \r\n" + 
				"<ul class=\"tabs-list\">\r\n" + 
				"      \r\n" + 
				"<li>\r\n" + 
				" \r\n" + 
				"<a href=\"http://www.correios.com.br/para-voce\">\r\n" + 
				"        \r\n" + 
				"<h2>\r\n" + 
				"Voc&ecirc;\r\n" + 
				"</h2>\r\n" + 
				"        \r\n" + 
				"</a>\r\n" + 
				" \r\n" + 
				"</li>\r\n" + 
				"      \r\n" + 
				"<li>\r\n" + 
				" \r\n" + 
				"<a href=\"http://www.correios.com.br/para-sua-empresa\">\r\n" + 
				"        \r\n" + 
				"<h2>\r\n" + 
				"Sua Empresa\r\n" + 
				"</h2>\r\n" + 
				"        \r\n" + 
				"</a>\r\n" + 
				" \r\n" + 
				"</li>\r\n" + 
				"      \r\n" + 
				"<li>\r\n" + 
				" \r\n" + 
				"<a href=\"http://www.correios.com.br/Para-governo\">\r\n" + 
				"        \r\n" + 
				"<h2>\r\n" + 
				"Governo\r\n" + 
				"</h2>\r\n" + 
				"        \r\n" + 
				"</a>\r\n" + 
				" \r\n" + 
				"</li>\r\n" + 
				"      \r\n" + 
				"<li>\r\n" + 
				" \r\n" + 
				"<a href=\"http://www.correios.com.br/sobre-correios\">\r\n" + 
				"        \r\n" + 
				"<h2>\r\n" + 
				"Sobre Correios\r\n" + 
				"</h2>\r\n" + 
				"        \r\n" + 
				"</a>\r\n" + 
				" \r\n" + 
				"</li>\r\n" + 
				"      \r\n" + 
				"<li>\r\n" + 
				" \r\n" + 
				"<a href=\"http://www.correios.com.br/correios-online\">\r\n" + 
				"        \r\n" + 
				"<h2>\r\n" + 
				"Correios On-line\r\n" + 
				"</h2>\r\n" + 
				"        \r\n" + 
				"</a>\r\n" + 
				" \r\n" + 
				"</li>\r\n" + 
				"      \r\n" + 
				"<li class=\"current\">\r\n" + 
				" \r\n" + 
				"<a href=\"default.cfm\">\r\n" + 
				"        \r\n" + 
				"<h2>\r\n" + 
				"Sistemas\r\n" + 
				"</h2>\r\n" + 
				"        \r\n" + 
				"</a>\r\n" + 
				" \r\n" + 
				"</li>\r\n" + 
				"    \r\n" + 
				"</ul>\r\n" + 
				"  \r\n" + 
				"</div>\r\n" + 
				"   \r\n" + 
				"<!-- /header --->\r\n" + 
				"<div class=\"wrap\">\r\n" + 
				"   \r\n" + 
				"<div class=\"content\">\r\n" + 
				"<div class=\"laminas\" style=\"display: block;\">\r\n" + 
				"<div class=\"column1\">\r\n" + 
				"<span class=\"mver\">\r\n" + 
				" \r\n" + 
				"<span class=\"dominio\">\r\n" + 
				"</span>\r\n" + 
				"<h3>\r\n" + 
				"Busca CEP\r\n" + 
				"<br>\r\n" + 
				"	\r\n" + 
				"<font size=\"-5\">\r\n" + 
				"&nbsp;Versão DNE: 1803 \r\n" + 
				"</font>\r\n" + 
				"</h3>\r\n" + 
				"<ul>\r\n" + 
				"	\r\n" + 
				"<li>\r\n" + 
				"		\r\n" + 
				"<a href=\"sistemas/buscacep/buscaCepEndereco.cfm\">\r\n" + 
				"CEP ou Endereço\r\n" + 
				"</a>\r\n" + 
				"	\r\n" + 
				"</li>\r\n" + 
				"	\r\n" + 
				"<li>\r\n" + 
				"		\r\n" + 
				"<a href=\"sistemas/buscacep/buscaCep.cfm\">\r\n" + 
				"CEP por Localidade | Logradouro\r\n" + 
				"</a>\r\n" + 
				"	\r\n" + 
				"</li>\r\n" + 
				"		\r\n" + 
				"<li>\r\n" + 
				"		\r\n" + 
				"<a href=\"sistemas/buscacep/buscaEndereco.cfm\">\r\n" + 
				"Endereço por CEP\r\n" + 
				"</a>\r\n" + 
				"	\r\n" + 
				"</li>\r\n" + 
				"		\r\n" + 
				"<li>\r\n" + 
				"		\r\n" + 
				"<a href=\"sistemas/buscacep/buscaLogBairro.cfm\">\r\n" + 
				"CEP de Logradouro por Bairro\r\n" + 
				"</a>\r\n" + 
				"	\r\n" + 
				"</li>\r\n" + 
				"		\r\n" + 
				"<li>\r\n" + 
				"		\r\n" + 
				"<a href=\"sistemas/buscacep/buscaFaixaCep.cfm\">\r\n" + 
				"Faixas de CEP\r\n" + 
				"</a>\r\n" + 
				"	\r\n" + 
				"</li>\r\n" + 
				"	\r\n" + 
				"<li>\r\n" + 
				"		\r\n" + 
				"<a href=\"sistemas/buscacep/buscaCaixaPostal.cfm\">\r\n" + 
				"Caixa Postal\r\n" + 
				"</a>\r\n" + 
				"	\r\n" + 
				"</li>\r\n" + 
				"	\r\n" + 
				"<li>\r\n" + 
				"			\r\n" + 
				"</li>\r\n" + 
				"		\r\n" + 
				"<li>\r\n" + 
				"		\r\n" + 
				"<a href=\"http://www.correios.com.br/precisa-de-ajuda/o-que-e-cep-e-por-que-usa-lo/o-que-e-cep\">\r\n" + 
				"Por que usar o CEP?\r\n" + 
				"</a>\r\n" + 
				"	\r\n" + 
				"</li>\r\n" + 
				"		\r\n" + 
				"<li>\r\n" + 
				"		\r\n" + 
				"<a href=\"http://www.correios.com.br/precisa-de-ajuda/o-que-e-cep-e-por-que-usa-lo/estrutura-do-cep\">\r\n" + 
				"Estrutura do CEP\r\n" + 
				"</a>\r\n" + 
				"	\r\n" + 
				"</li>\r\n" + 
				"		\r\n" + 
				"<li>\r\n" + 
				"		\r\n" + 
				"<a href=\"sistemas/buscacep/cepFormas.cfm\">\r\n" + 
				"Formas de Endereçamento\r\n" + 
				"</a>\r\n" + 
				"	\r\n" + 
				"</li>\r\n" + 
				"		\r\n" + 
				"<li>\r\n" + 
				"		\r\n" + 
				"<a href=\"sistemas/buscacep/cepFormasDF.cfm\">\r\n" + 
				"Formas de Endereçamento para Regiões Administrativas do DF\r\n" + 
				"</a>\r\n" + 
				"</li>\r\n" + 
				"	\r\n" + 
				"<li>\r\n" + 
				"		\r\n" + 
				"<a href=\"http://www.correios.com.br/precisa-de-ajuda/busca-cep/novas-cidades-codificadas-por-logradouros\">\r\n" + 
				"Cidades Codificadas por Logradouros\r\n" + 
				"</a>\r\n" + 
				"	\r\n" + 
				"</li>\r\n" + 
				"			\r\n" + 
				"<li>\r\n" + 
				"		\r\n" + 
				"<a href=\"http://www.correios.com.br/precisa-de-ajuda/busca-cep/alteracao-de-faixas-de-cep\">\r\n" + 
				"Alteração de CEP/Faixas de CEP\r\n" + 
				"</a>\r\n" + 
				"	\r\n" + 
				"</li>\r\n" + 
				"		\r\n" + 
				"<li>\r\n" + 
				"		\r\n" + 
				"<a href=\"http://www.correios.com.br/precisa-de-ajuda/o-que-e-cep-e-por-que-usa-lo/cep-para-areas-rurais\">\r\n" + 
				"CEP para Áreas Rurais\r\n" + 
				"</a>\r\n" + 
				"	\r\n" + 
				"</li>\r\n" + 
				"	\r\n" + 
				"<li>\r\n" + 
				"		\r\n" + 
				"<a href=\"https://www.correios.com.br/precisa-de-ajuda/busca-cep/cep-de-outros-paises/\">\r\n" + 
				"CEP de outros Países\r\n" + 
				"</a>\r\n" + 
				"	\r\n" + 
				"</li>\r\n" + 
				"	\r\n" + 
				"</ul>\r\n" + 
				" \r\n" + 
				"</span>\r\n" + 
				"<!-- Fim Menu vertical -->\r\n" + 
				"</div>\r\n" + 
				"<!-- column1 -->\r\n" + 
				"<div class=\"column2\">\r\n" + 
				"<div class=\"breadcrumb\">\r\n" + 
				"</div>\r\n" + 
				"<div class=\"content \">\r\n" + 
				"<a name=\"ancora\">\r\n" + 
				"</a>\r\n" + 
				"<div class=\"tituloimagem\">\r\n" + 
				"<h3>\r\n" + 
				"Busca CEP - Endere&ccedil;o\r\n" + 
				"</h3>\r\n" + 
				"</div>\r\n" + 
				"<div class=\"ctrlcontent\">\r\n" + 
				"<script language=\"JavaScript\" type=\"text/javascript\">\r\n" + 
				"function detalhaCep(CEP){   document.Geral.CEP.value = CEP;document.Geral.action='sistemas/buscacep/detalhaCEP.cfm';document.Geral.submit();}\r\n" + 
				"</script>\r\n" + 
				"<p>\r\n" + 
				"DADOS ENCONTRADOS COM SUCESSO.\r\n" + 
				"</p>\r\n" + 
				"   				\r\n" + 
				"<div style=\"float:left\">\r\n" + 
				"[ Anterior ]		\r\n" + 
				"</div>\r\n" + 
				"<div style=\"float:left\">\r\n" + 
				"				[ Pr&oacute;xima ]\r\n" + 
				"</div>\r\n" + 
				"<div style=\"float:left\">\r\n" + 
				"<a href=\"sistemas/buscacep/BuscaCepEndereco.cfm\">\r\n" + 
				"[ Nova Consulta ]\r\n" + 
				"</a>\r\n" + 
				"							\r\n" + 
				"</div>\r\n" + 
				"	&nbsp;&nbsp;1 a 1 de 1\r\n" + 
				"<br>\r\n" + 
				"<br>\r\n" + 
				"  \r\n" + 
				"<form name=\"Geral\" id=\"Geral\" action=\"&#x2f;sistemas&#x2f;buscacep&#x2f;resultadoBuscaCepEndereco.cfm\" method=\"post\" onsubmit=\"return _CF_checkGeral(this)\">\r\n" + 
				"<input type=\"hidden\" name=\"CEP\" value=\"\">\r\n" + 
				"</form>\r\n" + 
				" \r\n" + 
				"<table class=\"tmptabela\">\r\n" + 
				"<tr >\r\n" + 
				"<th width=\"150\">\r\n" + 
				"Logradouro/Nome:\r\n" + 
				"</th>\r\n" + 
				"<th width=\"90\">\r\n" + 
				"Bairro/Distrito:\r\n" + 
				"</th>\r\n" + 
				"<th width=\"80\">\r\n" + 
				"Localidade/UF:\r\n" + 
				"</th>\r\n" + 
				"<th width=\"50\">\r\n" + 
				"CEP:\r\n" + 
				"</th>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td width=\"150\">\r\n" + 
				"Rua Canhotinho&nbsp;\r\n" + 
				"</td>\r\n" + 
				"<td width=\"90\">\r\n" + 
				"Heliópolis&nbsp;\r\n" + 
				"</td>\r\n" + 
				"<td width=\"80\">\r\n" + 
				"Garanhuns/PE\r\n" + 
				"</td>\r\n" + 
				"<td width=\"55\">\r\n" + 
				"55295-555\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"							\r\n" + 
				"</table>\r\n" + 
				"<div style=\"float:left\">\r\n" + 
				"  [ Anterior ]	\r\n" + 
				"</div>\r\n" + 
				"<div style=\"float:left\">\r\n" + 
				"					[ Pr&oacute;xima ]\r\n" + 
				"</div>\r\n" + 
				"<div style=\"float:left\">\r\n" + 
				"<a href=\"sistemas/buscacep/BuscaCepEndereco.cfm\">\r\n" + 
				"[ Nova Consulta ]\r\n" + 
				"</a>\r\n" + 
				"</div>\r\n" + 
				"				 \r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"<br class=\"clr\" />\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"<!-- class=\"wrap\" -->\r\n" + 
				"<!-- laminas -->\r\n" + 
				"<div class=\"footer\">\r\n" + 
				"  \r\n" + 
				"<div class=\"wrap\">\r\n" + 
				"          \r\n" + 
				"<div class=\"column-footer\">\r\n" + 
				"        \r\n" + 
				"<h3>\r\n" + 
				"<a href=\"sistemas/falecomoscorreios\">\r\n" + 
				"Fale com os Correios\r\n" + 
				"</a>\r\n" + 
				"</h3>\r\n" + 
				"        \r\n" + 
				"<ul>\r\n" + 
				"          \r\n" + 
				"<li class=\"node\">\r\n" + 
				"<a href=\"sistemas/falecomoscorreios\">\r\n" + 
				"Manifestação via Internet\r\n" + 
				"</a>\r\n" + 
				"            \r\n" + 
				"<ul>\r\n" + 
				"              \r\n" + 
				"<li>\r\n" + 
				"<a href=\"sistemas/falecomoscorreios\">\r\n" + 
				"Fale Conosco pelo site\r\n" + 
				"</a>\r\n" + 
				"</li>\r\n" + 
				"            \r\n" + 
				"</ul>\r\n" + 
				"          \r\n" + 
				"</li>\r\n" + 
				"          \r\n" + 
				"<li class=\"node\">\r\n" + 
				" \r\n" + 
				"<a href=\"sistemas/falecomoscorreios\">\r\n" + 
				"Atendimento telef&ocirc;nico\r\n" + 
				"</a>\r\n" + 
				"            \r\n" + 
				"<ul>\r\n" + 
				"              \r\n" + 
				"<li>\r\n" + 
				"3003 0100 (Capitais e Regi&atilde;o Metropolitanas)\r\n" + 
				"</li>\r\n" + 
				"              \r\n" + 
				"<li>\r\n" + 
				"0800 725 7282 (Demais localidades)\r\n" + 
				"</li>\r\n" + 
				"              \r\n" + 
				"<li>\r\n" + 
				"0800 725 0100 (Sugest&otilde;es ou reclama&ccedil;&otilde;es)\r\n" + 
				"</li>\r\n" + 
				"              \r\n" + 
				"<li>\r\n" + 
				"0800 725 0898 (exclusivo para portadores \r\n" + 
				"<br/>\r\n" + 
				"                de deficiência auditiva) \r\n" + 
				"</li>\r\n" + 
				"              \r\n" + 
				"<li>\r\n" + 
				"3003 1383 (Informações Banco Postal)\r\n" + 
				"</li>\r\n" + 
				"            \r\n" + 
				"</ul>\r\n" + 
				"          \r\n" + 
				"</li>\r\n" + 
				"          \r\n" + 
				"<li class=\"node\">\r\n" + 
				" \r\n" + 
				"<a href=\"sistemas/agencias/\">\r\n" + 
				"Rede de atendimento\r\n" + 
				"</a>\r\n" + 
				"            \r\n" + 
				"<ul>\r\n" + 
				"              \r\n" + 
				"<li>\r\n" + 
				"<a href=\"sistemas/agencias\">\r\n" + 
				"Consulte endereços e horários de atendimentos \r\n" + 
				"<br />\r\n" + 
				"                das agências dos Correios\r\n" + 
				"</a>\r\n" + 
				"</li>\r\n" + 
				"            \r\n" + 
				"</ul>\r\n" + 
				"          \r\n" + 
				"</li>\r\n" + 
				"          \r\n" + 
				"<li class=\"node\">\r\n" + 
				" \r\n" + 
				"<a href=\"http://www.correios.com.br/sobre-correios/fale-com-os-correios/ouvidoria\">\r\n" + 
				"Ouvidoria\r\n" + 
				"</a>\r\n" + 
				" \r\n" + 
				"</li>\r\n" + 
				"        \r\n" + 
				"</ul>\r\n" + 
				"      \r\n" + 
				"</div>\r\n" + 
				"      \r\n" + 
				"<div class=\"column-footer\">\r\n" + 
				"        \r\n" + 
				"<h3>\r\n" + 
				"<a href=\"\">\r\n" + 
				"Portal Correios\r\n" + 
				"</a>\r\n" + 
				"</h3>\r\n" + 
				"        \r\n" + 
				"<ul>\r\n" + 
				"          \r\n" + 
				"<li>\r\n" + 
				"<a href=\"http://www.correios.com.br/sitemap\">\r\n" + 
				"Mapa do site\r\n" + 
				"</a>\r\n" + 
				"</li>\r\n" + 
				"          \r\n" + 
				"<li>\r\n" + 
				"<a href=\"sistemas/rastreamento/default.cfm\">\r\n" + 
				"Rastreamento de objetos\r\n" + 
				"</a>\r\n" + 
				"</li>\r\n" + 
				"          \r\n" + 
				"<li>\r\n" + 
				"<a href=\"http://www.correios.com.br/correios/sobre-correios/sala-de-imprensa/fale-com-a-assessoria-de-comunicacao\">\r\n" + 
				"Sala de Imprensa\r\n" + 
				"</a>\r\n" + 
				"</li>\r\n" + 
				"          \r\n" + 
				"<li>\r\n" + 
				"<a href=\"institucional/concursos/correios/default.cfm\">\r\n" + 
				"Concursos\r\n" + 
				"</a>\r\n" + 
				"</li>\r\n" + 
				"          \r\n" + 
				"<li>\r\n" + 
				"<a href=\"http://www.correios.com.br/correios/sobre-correios/patrocinio/patrocinio\">\r\n" + 
				"Patroc&iacute;nios\r\n" + 
				"</a>\r\n" + 
				"</li>\r\n" + 
				"          \r\n" + 
				"<li>\r\n" + 
				"<a href=\"http://www.correios.com.br/para-voce/correios-de-a-a-z/contatos-comerciais\">\r\n" + 
				"Contatos comerciais\r\n" + 
				"</a>\r\n" + 
				"</li>\r\n" + 
				"          \r\n" + 
				"<li>\r\n" + 
				"<a href=\"http://www.correios.com.br/correios/sobre-correios/a-empresa/carta-de-servicos-ao-cidadao\">\r\n" + 
				"Carta de servi&ccedil;os ao cidad&atilde;o\r\n" + 
				"</a>\r\n" + 
				"</li>\r\n" + 
				"          \r\n" + 
				"<li>\r\n" + 
				"<a href=\"http://www.correios.com.br/sobre-correios/fale-com-os-correios/denuncias/denuncias/\">\r\n" + 
				"Denúncia\r\n" + 
				"</a>\r\n" + 
				"</li>\r\n" + 
				"          \r\n" + 
				"<li>\r\n" + 
				"<a href=\"http://www.mc.gov.br/\">\r\n" + 
				"Minist&eacute;rio das Comunica&ccedil;&otilde;es\r\n" + 
				"</a>\r\n" + 
				"</li>\r\n" + 
				"        \r\n" + 
				"</ul>\r\n" + 
				"      \r\n" + 
				"</div>\r\n" + 
				"      \r\n" + 
				"<div class=\"column-footer\">\r\n" + 
				"        \r\n" + 
				"<h3>\r\n" + 
				"<a href=\"\">\r\n" + 
				"Outros sites dos Correios\r\n" + 
				"</a>\r\n" + 
				"</h3>\r\n" + 
				"        \r\n" + 
				"<ul>\r\n" + 
				"          \r\n" + 
				"<li>\r\n" + 
				"<a href=\"http://www.correios.com.br/para-voce\">\r\n" + 
				"Correios para voc&ecirc;\r\n" + 
				"</a>\r\n" + 
				"</li>\r\n" + 
				"          \r\n" + 
				"<li>\r\n" + 
				"<a href=\"http://www.correios.com.br/para-sua-empresa\">\r\n" + 
				"Correios para sua empresa\r\n" + 
				"</a>\r\n" + 
				"</li>\r\n" + 
				"          \r\n" + 
				"<li>\r\n" + 
				"<a href=\"http://www.correios.com.br/sobre-correios\">\r\n" + 
				"Sobre Correios\r\n" + 
				"</a>\r\n" + 
				"</li>\r\n" + 
				"          \r\n" + 
				"<li>\r\n" + 
				"<a href=\"http://shopping.correios.com.br/correiosonline\">\r\n" + 
				"Loja virtual dos Correios\r\n" + 
				"</a>\r\n" + 
				"</li>\r\n" + 
				"          \r\n" + 
				"<li>\r\n" + 
				"<a href=\"http://blog.correios.com.br/correios\">\r\n" + 
				"Blog dos Correios\r\n" + 
				"</a>\r\n" + 
				"</li>\r\n" + 
				"          \r\n" + 
				"<li>\r\n" + 
				"<a href=\"http://blog.correios.com.br/filatelia\">\r\n" + 
				"Espa&ccedil;o da Filatelia\r\n" + 
				"</a>\r\n" + 
				"</li>\r\n" + 
				"          \r\n" + 
				"<li>\r\n" + 
				"<a href=\"http://m.correios.com.br/\">\r\n" + 
				"Correios Mobile\r\n" + 
				"</a>\r\n" + 
				"</li>\r\n" + 
				"          \r\n" + 
				"<li>\r\n" + 
				"<a href=\"http://www2.correios.com.br/\">\r\n" + 
				"Sistemas dos Correios\r\n" + 
				"</a>\r\n" + 
				"</li>\r\n" + 
				"        \r\n" + 
				"</ul>\r\n" + 
				"      \r\n" + 
				"</div>\r\n" + 
				"      \r\n" + 
				"<div class=\"copy\">\r\n" + 
				" \r\n" + 
				"<a href=\"http://www.correios.com.br/sobre-correios/fale-com-os-correios/politica-de-privacidade-e-notas-legais/\">\r\n" + 
				"Pol&iacute;tica de Privacidade e notas legais\r\n" + 
				"</a>\r\n" + 
				" -  © Copyright  2014 Correios - Todos os direitos reservados. \r\n" + 
				"</div>\r\n" + 
				"        \r\n" + 
				"</div>\r\n" + 
				"  \r\n" + 
				"</div>\r\n" + 
				" \r\n" + 
				"</div>\r\n" + 
				"<!-- class=\"back\" -->\r\n" + 
				"</body>\r\n" + 
				"</html>\r\n" + 
				"<script type=\"text/javascript\">\r\n" + 
				"ddaccordion.init({	headerclass: \"expo\", //Shared CSS class name of headers group	contentclass: \"dados\", //Shared CSS class name of contents group	revealtype: \"click\", //Reveal content when user clicks or onmouseover the header? Valid value: \"click\", \"clickgo\", or \"mouseover\"	mouseoverdelay: 100, //if revealtype=\"mouseover\", set delay in milliseconds before header expands onMouseover	collapseprev: false, //Collapse previous content (so only one open at any time)? true/false	defaultexpanded: [], //index of content(s) open by default [index1, index2, etc] [] denotes no content	onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)	animatedefault: false, //Should contents open by default be animated into view?	persiststate: false, //persist state of opened contents within browser session?	toggleclass: [\"\", \"selected\"], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively [\"class1\", \"class2\"]	togglehtml: [\"\", \"\", \"\"], //Additional HTML added to the header when it's collapsed and expanded, respectively  [\"position\", \"html1\", \"html2\"] (see docs)	animatespeed: \"normal\", //speed of animation: integer in milliseconds (ie: 200), or keywords \"fast\", \"normal\", or \"slow\"	oninit:function(headers, expandedindices){ //custom code to run when headers have initalized		//do nothing	},	onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed	}})ddaccordion.init({	headerclass: \"abarotulo\", //Shared CSS class name of headers group	contentclass: \"submenu\", //Shared CSS class name of contents group	revealtype: \"mouseover\", //Reveal content when user clicks or onmouseover the header? Valid value: \"click\", \"clickgo\", or \"mouseover\"	mouseoverdelay: 100, //if revealtype=\"mouseover\", set delay in milliseconds before header expands onMouseover	collapseprev: true, //Collapse previous content (so only one open at any time)? true/false	defaultexpanded: [], //index of content(s) open by default [index1, index2, etc] [] denotes no content	onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)	animatedefault: false, //Should contents open by default be animated into view?	persiststate: false, //persist state of opened contents within browser session?	toggleclass: [\"\", \"selected\"], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively [\"class1\", \"class2\"]	togglehtml: [\"\", \"\", \"\"], //Additional HTML added to the header when it's collapsed and expanded, respectively  [\"position\", \"html1\", \"html2\"] (see docs)	animatespeed: \"fast\", //speed of animation: integer in milliseconds (ie: 200), or keywords \"fast\", \"normal\", or \"slow\"	oninit:function(headers, expandedindices){ //custom code to run when headers have initalized		//do nothing	},	onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed				}})/*Agencias*/ddaccordion.init({	headerclass: \"expodados\", //Shared CSS class name of headers group	contentclass: \"contentexpodados\", //Shared CSS class name of contents group	revealtype: \"click\", //Reveal content when user clicks or onmouseover the header? Valid value: \"click\", \"clickgo\", or \"mouseover\"	mouseoverdelay: 0, //if revealtype=\"mouseover\", set delay in milliseconds before header expands onMouseover	collapseprev: false, //Collapse previous content (so only one open at any time)? true/false	defaultexpanded: [], //index of content(s) open by default [index1, index2, etc] [] denotes no content	onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)	animatedefault: false, //Should contents open by default be animated into view?	persiststate: false, //persist state of opened contents within browser session?	toggleclass: [\"\", \"selected\"], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively [\"class1\", \"class2\"]	togglehtml: [\"\", \"\", \"\"], //Additional HTML added to the header when it's collapsed and expanded, respectively  [\"position\", \"html1\", \"html2\"] (see docs)	animatespeed: \"fast\", //speed of animation: integer in milliseconds (ie: 200), or keywords \"fast\", \"normal\", or \"slow\"	oninit:function(headers, expandedindices){ //custom code to run when headers have initalized		//do nothing	},	onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed		//do nothing	}})function iconeAbaMouseOut(){	$('ul.iconeaba').mouseleave(function() {		ddaccordion.collapseall('abarotulo');	});	}function produtosAZMouseOut(){	$('div.produtosaz').mouseleave(function() {		ddaccordion.collapseall('expo');	});	}function produtosAZtrocaMostraTudo(){	$('#abreTudo').css('display','block');	$('#abreFecha a').click(function() {		$(\"#abreFecha a\").toggle();	});	}function cbDivMouseOut(){	$('div.cbDiv').mouseleave(function() {		ddaccordion.collapseall('expo');	});	}$(document).ready(function(){	iconeAbaMouseOut();	produtosAZMouseOut();	produtosAZtrocaMostraTudo();	cbDivMouseOut();	});\r\n" + 
				"</script>\r\n" + 
				" \r\n" + 
				"<script type=\"text/javascript\">\r\n" + 
				" 		$(document).ready(function(){ 		$.jtabber({			mainLinkTag: \"#nav a\", // much like a css selector, you must have a 'title' attribute that links to the div id name			activeLinkClass: \"selected\", // class that is applied to the tab once it's clicked			hiddenContentClass: \"hiddencontent\", // the class of the content you are hiding until the tab is clicked			//showDefaultTab: null, // 1 will open the first tab, 2 will open the second etc.  null will open nothing by default			showErrors: false, // true/false - if you want errors to be alerted to you			effect: null, // null, 'slide' or 'fade' - do you want your content to fade in or slide in?			effectSpeed: 'fast' // 'slow', 'medium' or 'fast' - the speed of the effect		}) 		})  		$(document).ready(function(){ 		$.jtabber({			mainLinkTag: \"#seletorforms select option\", // much like a css selector, you must have a 'title' attribute that links to the div id name			activeLinkClass: \"selected\", // class that is applied to the tab once it's clicked			hiddenContentClass: \"hiddencontent2\", // the class of the content you are hiding until the tab is clicked			showDefaultTab: null, // 1 will open the first tab, 2 will open the second etc.  null will open nothing by default			showErrors: false, // true/false - if you want errors to be alerted to you			effect: 'slide', // null, 'slide' or 'fade' - do you want your content to fade in or slide in?			effectSpeed: 'fast' // 'slow', 'medium' or 'fast' - the speed of the effect		}) 		}) 		$(document).ready(function(){ 		$.jtabber({			mainLinkTag: \"#seletorforms2 select option\", // much like a css selector, you must have a 'title' attribute that links to the div id name			activeLinkClass: \"selected\", // class that is applied to the tab once it's clicked			hiddenContentClass: \"hiddencontent3\", // the class of the content you are hiding until the tab is clicked			showDefaultTab: null, // 1 will open the first tab, 2 will open the second etc.  null will open nothing by default			showErrors: false, // true/false - if you want errors to be alerted to you			effect: 'slide', // null, 'slide' or 'fade' - do you want your content to fade in or slide in?			effectSpeed: 'fast' // 'slow', 'medium' or 'fast' - the speed of the effect		}) 		})				$(document).ready(function(){ 		$.jtabber({			mainLinkTag: \"#wizard a\", // much like a css selector, you must have a 'title' attribute that links to the div id name			activeLinkClass: \"selected\", // class that is applied to the tab once it's clicked			hiddenContentClass: \"hiddencontent4\", // the class of the content you are hiding until the tab is clicked			showDefaultTab: 1, // 1 will open the first tab, 2 will open the second etc.  null will open nothing by default			showErrors: false, // true/false - if you want errors to be alerted to you			effect: null, // null, 'slide' or 'fade' - do you want your content to fade in or slide in?			effectSpeed: 'fast' // 'slow', 'medium' or 'fast' - the speed of the effect		}) 		})		\r\n" + 
				"</script>\r\n" + 
				" 		\r\n" + 
				"<script>\r\n" + 
				"			$(document).ready(function(){				//Examples of how to assign the ColorBox event to elements				$(\".group1\").colorbox({rel:'group1'});				$(\".group2\").colorbox({rel:'group2', transition:\"fade\"});				$(\".group3\").colorbox({rel:'group3', transition:\"none\", width:\"75%\", height:\"75%\"});				$(\".group4\").colorbox({rel:'group4', slideshow:true});				$(\".ajax\").colorbox();				$(\".youtube\").colorbox({iframe:true, innerWidth:425, innerHeight:344});				$(\".iframe\").colorbox({iframe:true, width:\"80%\", height:\"80%\"});				$(\".inline\").colorbox({inline:true, width:\"50%\"});				$(\".inline2\").colorbox({inline:true, width:\"340px\"});				$(\".inline3\").colorbox({inline:true, width:\"70%\"});				$(\".callbacks\").colorbox({					onOpen:function(){ alert('onOpen: colorbox is about to open'); },					onLoad:function(){ alert('onLoad: colorbox has started to load the targeted content'); },					onComplete:function(){ alert('onComplete: colorbox has displayed the loaded content'); },					onCleanup:function(){ alert('onCleanup: colorbox has begun the close process'); },					onClosed:function(){ alert('onClosed: colorbox has completely closed'); }				});								//Example of preserving a JavaScript event for inline calls.				$(\"#click\").click(function(){ 					$('#click').css({\"background-color\":\"#f00\", \"color\":\"#fff\", \"cursor\":\"inherit\"}).text(\"Open this window again and this message will still be here.\");					return false;				});			});		\r\n" + 
				"</script>\r\n" + 
				"  \r\n" + 
				"<!-- contentobjects: page generated at 2016-07-28 01:38 PM -->";
		HTMLObject html = HTMLObject.parse(txt);

		ArrayList<HTMLObject> aaa = html.getObjectsByTag("table");

		for(HTMLObject in : aaa) {
			System.out.println(in.getHtmlSourceAsHtml());

			System.out.println(in.getAttributes());
		}
	}

	public static HTMLObject parse(String html) {
		Pattern pattern_TAG_FINISH = Pattern.compile(TAG_FINISH);
		Pattern pattern_TAG_FINISH_INLINE = Pattern.compile(TAG_FINISH_INLINE);
		Pattern pattern_comment_start = Pattern.compile(HTML_COMMENT_START);
		Pattern pattern_comment_end = Pattern.compile(HTML_COMMENT_END);

		ArrayList<HTMLObject> allObjects = new ArrayList<>();

		html = html.replaceAll(TAG_START, CRLF + TAG_START);
		html = html.replaceAll(TAG_END, TAG_END + CRLF);
		html = html.replaceAll(TAG_FINISH, CRLF + TAG_FINISH);
		html = html.replaceAll("[" + CRLF + "]+", JAVA_CRLF).trim();
		html = html.replaceAll("[" + JAVA_CRLF + "]+", JAVA_CRLF).trim();

		//Remove trash here
		html = html.replaceAll("<!-->", "-->");

		String path3 = "C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\teste_HTMLOBJECT.html";
		Util.escreverEmArquivo(path3, html, false);

		//Removing comments: find ending tags
		ArrayList<HTMLObject> comments = new ArrayList<>();
		String[] main = html.split("\n");
		for(int i=0; i< main.length; i++) {
			if(pattern_comment_end.matcher(main[i]).find()) {
				comments.add(new HTMLObject("comment", -1, i+1, null, main[i]));
				//				System.out.println(main[i]);
			}
		}

		//Removing comments: find start tags
		String[] commentAux = html.split("\n");
		for(HTMLObject in : comments) {
			inner:
				for(int i = in.getLine_end() - 1; i >= 0; i--) {
					if(pattern_comment_start.matcher(commentAux[i]).lookingAt()) {
						in.setLine_start(i + 1);
						in.setStr_start(commentAux[i]);

						//after find the correspondent pattern, erase it all, to avoid conflict with equals tags
						for(int j = in.getLine_start() - 1; j <= in.getLine_end() - 1; j++){
							commentAux[j] = "";
						}
						break inner;
					}
				}
		}
		/**
		 * Find tag endings like <TAG>...</TAG> and <TAG ... />
		 */
		main = commentAux;

		for(int i=0; i< main.length; i++) {
			String in = main[i].trim();
			if(pattern_TAG_FINISH_INLINE.matcher(in).find()) {//Check if object is inline type
				String title = in.split(" ")[0].replace(TAG_START, "");
				HTMLObject o = new HTMLObject(title, i+1, i+1, in, in);
				o.setInlineTag(true);
				allObjects.add(o);
			} else if(pattern_TAG_FINISH.matcher(in).lookingAt()) {//has to come after pattern_TAG_FINISH_INLINE
				allObjects.add(new HTMLObject(in.replace(TAG_FINISH, "").replace(TAG_END, ""), -1, i+1, null, in));
			}
		}

		//Find tag beginnings
		String[] mainAux = html.split("\n");
		for(HTMLObject in : allObjects) {
			if(in.inlineTag) {
				continue;//because tags already was found
			} else if(in.isInlineTag()) {
				mainAux[in.getLine_start()-1] = "";
			}

			String aux = TAG_START + in.getTag();
			Pattern tagStart = Pattern.compile(aux);
			inner:
				for(int i = in.getLine_end() - 1; i >= 0; i--) {
					if(tagStart.matcher(mainAux[i]).lookingAt()) {
						in.setLine_start(i + 1);
						in.setStr_start(mainAux[i]);

						//after find the correspondent pattern, erase it all, to avoid conflict with equals tags
						for(int j = in.getLine_start() - 1; j <= in.getLine_end() - 1; j++){
							in.htmlSource += main[j].trim();
							//if(in.tag.equals("form"))
							//System.out.println(main[j].trim());
							mainAux[j] = "";
						}
						break inner;
					}
				}
		}

		//Ordering by start tag line
		Collections.sort(allObjects, new ComparadorCrescente());

		//Giving childrens
		for(int i = allObjects.size()-1; i >= 0; i--) {
			inner:
				for(int j = allObjects.size()-1; j >= 0; j--) {
					try {
						if(allObjects.get(i).equals(allObjects.get(j))) {
							break inner;//when reaches itself, break. There's no object that can be smaller (at list order) and still be children
						}
					} catch(NullPointerException e) {
						System.out.println(i + " <> "+ j + "\n\n");
						e.printStackTrace();
					}
					if((!allObjects.get(j).getHasParent()) && 
							allObjects.get(i).getLine_start() <= allObjects.get(j).getLine_start() && 
							allObjects.get(i).getLine_end() > allObjects.get(j).getLine_end()) {
						//						System.out.println(array.get(j).toString2() + "  |  " + array.get(i).toString2());
						allObjects.get(j).setHasParent(true);
						allObjects.get(i).addChildren(allObjects.get(j));

						//Ordering childrens at every moment
						Collections.sort(allObjects.get(i).getChildrens(), new ComparadorCrescente());
					}
				}
		}

		//		//getting attributes
		//		for(HTMLObject in: allObjects) {
		//			if(in.getStr_start() == null) {
		//				continue;
		//			}
		//			String pattern1 = "(.[\"]([^\"]*?)[\"](?:$|\\s))";
		//			String pattern2 = "(.[']([^']*?)['](?:$|\\s))";
		//			Pattern p1 = Pattern.compile(pattern1 + "|" + pattern2, Pattern.MULTILINE);
		//			Matcher m1 = p1.matcher(in.getStr_start());
		//
		//			ArrayList<String> stringaux = new ArrayList<>();
		//
		//			while (m1.find()) {
		//				String argAus = in.getStr_start().trim();
		//				for(String in1 : stringaux) {
		//					argAus = argAus.replace(in1, "").trim();
		//				}
		//
		//				String title = argAus.split("=")[0].trim();
		//				stringaux.add(title);
		//				String contentComQuotes = m1.group().toString().substring(0, m1.group().length()-1);
		//				stringaux.add(contentComQuotes);
		//
		//				
		//			}
		//
		//			Map<String, String> hash = new HashMap<String, String>();
		//			for(int i=0; i < stringaux.size();) {
		//				String title, content;
		//				try{
		//					title= stringaux.get(i++);
		//					content = stringaux.get(i++);
		//					content = content.substring(2, content.length() - 1);
		//
		//					hash.put(title, content);
		//					
		//					System.out.println(title + " == " + content);
		//				} catch(NullPointerException e) {
		//
		//				}
		//			}
		//			in.attributes = hash;
		//		}

		allObjects.get(0).allObjects = allObjects;

		return allObjects.get(0);
	}

	public boolean isInlineTag() {
		return inlineTag;
	}

	private void setInlineTag(boolean inlineTag) {
		this.inlineTag = inlineTag;
	}

	private void addChildren(HTMLObject obj) {
		this.childrens.add(obj);
	}

	public ArrayList<HTMLObject> getObjectsByTag(String tag){
		ArrayList<HTMLObject> aux = new ArrayList<>();
		for(HTMLObject in : allObjects) {
			if(in.getTag().equals(tag)) {
				aux.add(in);
			}
		}

		return (aux.size()!=0) ? aux : null;
	}

	public ArrayList<HTMLObject> getChildrens() {
		return this.childrens;
	}

	public Map<String, String> getAttributes() {
		return this.attributes;
	}

	private void addAttribute(String key, String value) {
		this.attributes.put(key, value);
	}

	private void setHasParent(Boolean hasParent) {
		this.hasParent = hasParent;
	}

	private boolean getHasParent() {
		return this.hasParent;
	}

	public String getTag() {
		return this.tag;
	}

	public HTMLObject(String tag, int line_start, int line_end, String str_start, String str_end) {
		super();
		this.line_start = line_start;
		this.line_end = line_end;
		this.tag = tag;
		this.str_start = str_start;
		this.str_end = str_end;
	}

	@Override
	public String toString() {
		String a = tag + ": starting at (" + line_start + ") ending at (" + line_end + ")";
		return a;
	}

	@Override
	public boolean equals(Object obj) {
		HTMLObject o = (HTMLObject)obj;

		if(this.getLine_start() == o.getLine_start() &&
				this.getLine_end() == o.getLine_end() &&
				((this.getStr_start() == null && this.getStr_start() == null) || this.getStr_start().equals(o.getStr_start())) &&
				((this.getStr_end() == null && this.getStr_end() == null) || this.getStr_end().equals(o.getStr_end()))) {
			return true;
		}
		return false;
	}

	protected int getLine_start() {
		return line_start;
	}

	protected void setLine_start(int line_start) {
		this.line_start = line_start;
	}

	protected int getLine_end() {
		return line_end;
	}

	protected void setLine_end(int line_end) {
		this.line_end = line_end;
	}

	protected String getStr_start() {
		return str_start;
	}

	protected void setStr_start(String str_start) {
		this.str_start = str_start;
	}

	protected String getStr_end() {
		return str_end;
	}

	protected void setStr_end(String str_end) {
		this.str_end = str_end;
	}
}
