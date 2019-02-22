

import React from 'react'
import { Router, Route, Switch } from 'dva/router'
import { LocaleProvider } from 'antd'
import zhCN from 'antd/lib/locale-provider/zh_CN'
// import enUS from 'antd/lib/locale-provider/en_US'
import Launcher from '../launcher/Launcher'
import ForgetPasswordForm from '../launcher/ForgetPasswordForm'

import GlobalComponents from './'


function RouterConfig({ history }) {

	const {PlatformBizApp} = GlobalComponents
	const {SiteBizApp} = GlobalComponents
	const {CatalogBizApp} = GlobalComponents
	const {LevelOneCategoryBizApp} = GlobalComponents
	const {LevelTwoCategoryBizApp} = GlobalComponents
	const {LevelNCategoryBizApp} = GlobalComponents
	const {BrandBizApp} = GlobalComponents
	const {ProductBizApp} = GlobalComponents
	const {BannerBizApp} = GlobalComponents
	const {ProfileBizApp} = GlobalComponents
	const {UserAlertBizApp} = GlobalComponents
	const {TargetBizApp} = GlobalComponents
	const {RatingBizApp} = GlobalComponents
	const {ReviewBizApp} = GlobalComponents
	const {BlogBizApp} = GlobalComponents
	const {BrandFilterBizApp} = GlobalComponents
	const {PriceFilterBizApp} = GlobalComponents
	const {CategoryFilterBizApp} = GlobalComponents
	const {NewProductBizApp} = GlobalComponents
	const {EditorPickProductBizApp} = GlobalComponents
	const {TopRatedProductBizApp} = GlobalComponents
	const {RecommandProductBizApp} = GlobalComponents
	const {UserDomainBizApp} = GlobalComponents
	const {UserWhiteListBizApp} = GlobalComponents
	const {SecUserBizApp} = GlobalComponents
	const {SecUserBlockingBizApp} = GlobalComponents
	const {UserAppBizApp} = GlobalComponents
	const {ListAccessBizApp} = GlobalComponents
	const {ObjectAccessBizApp} = GlobalComponents
	const {LoginHistoryBizApp} = GlobalComponents



  return (
    <LocaleProvider locale={zhCN}>
      <Router history={history}>
        <Switch>
         <Route path="/home" component={Launcher} />
         <Route path="/forgetpass" component={ForgetPasswordForm} />
          <Route path="/platform/" component={PlatformBizApp} />
          <Route path="/site/" component={SiteBizApp} />
          <Route path="/catalog/" component={CatalogBizApp} />
          <Route path="/levelOneCategory/" component={LevelOneCategoryBizApp} />
          <Route path="/levelTwoCategory/" component={LevelTwoCategoryBizApp} />
          <Route path="/levelNCategory/" component={LevelNCategoryBizApp} />
          <Route path="/brand/" component={BrandBizApp} />
          <Route path="/product/" component={ProductBizApp} />
          <Route path="/banner/" component={BannerBizApp} />
          <Route path="/profile/" component={ProfileBizApp} />
          <Route path="/userAlert/" component={UserAlertBizApp} />
          <Route path="/target/" component={TargetBizApp} />
          <Route path="/rating/" component={RatingBizApp} />
          <Route path="/review/" component={ReviewBizApp} />
          <Route path="/blog/" component={BlogBizApp} />
          <Route path="/brandFilter/" component={BrandFilterBizApp} />
          <Route path="/priceFilter/" component={PriceFilterBizApp} />
          <Route path="/categoryFilter/" component={CategoryFilterBizApp} />
          <Route path="/newProduct/" component={NewProductBizApp} />
          <Route path="/editorPickProduct/" component={EditorPickProductBizApp} />
          <Route path="/topRatedProduct/" component={TopRatedProductBizApp} />
          <Route path="/recommandProduct/" component={RecommandProductBizApp} />
          <Route path="/userDomain/" component={UserDomainBizApp} />
          <Route path="/userWhiteList/" component={UserWhiteListBizApp} />
          <Route path="/secUser/" component={SecUserBizApp} />
          <Route path="/secUserBlocking/" component={SecUserBlockingBizApp} />
          <Route path="/userApp/" component={UserAppBizApp} />
          <Route path="/listAccess/" component={ListAccessBizApp} />
          <Route path="/objectAccess/" component={ObjectAccessBizApp} />
          <Route path="/loginHistory/" component={LoginHistoryBizApp} />
         <Route path="/" component={Launcher} />
        </Switch>
      </Router>
    </LocaleProvider>
  )
}

export default RouterConfig










