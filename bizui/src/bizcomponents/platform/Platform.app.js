import React from 'react'
import PropTypes from 'prop-types'
import {
  Layout,
  Menu,
  Icon,
  Avatar,
  Dropdown,
  Tag,
  message,
  Spin,
  Breadcrumb,
  AutoComplete,
  Input,Button
} from 'antd'
import DocumentTitle from 'react-document-title'
import { connect } from 'dva'
import { Link, Route, Redirect, Switch } from 'dva/router'
import moment from 'moment'
import groupBy from 'lodash/groupBy'
import { ContainerQuery } from 'react-container-query'
import classNames from 'classnames'
import styles from './Platform.app.less'
import {sessionObject} from '../../utils/utils'

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';


import GlobalComponents from '../../custcomponents';

import PermissionSettingService from '../../permission/PermissionSetting.service'
import appLocaleName from '../../common/Locale.tool'

const  {  filterForMenuPermission } = PermissionSettingService

const isMenuItemForDisplay = (item, targetObject, targetComponent) => {
  return true
}

const filteredMenuItems = (targetObject, targetComponent) => {
    const menuData = sessionObject('menuData')
    const isMenuItemForDisplayFunc = targetComponent.props.isMenuItemForDisplayFunc||isMenuItemForDisplay
    return menuData.subItems.filter(item=>filterForMenuPermission(item,targetObject,targetComponent)).filter(item=>isMenuItemForDisplayFunc(item,targetObject,targetComponent))
}



const { Header, Sider, Content } = Layout
const { SubMenu } = Menu

const query = {
  'screen-xs': {
    maxWidth: 575,
  },
  'screen-sm': {
    minWidth: 576,
    maxWidth: 767,
  },
  'screen-md': {
    minWidth: 768,
    maxWidth: 991,
  },
  'screen-lg': {
    minWidth: 992,
    maxWidth: 1199,
  },
  'screen-xl': {
    minWidth: 1200,
  },
}




class PlatformBizApp extends React.PureComponent {
  constructor(props) {
    super(props)
     this.state = {
      openKeys: this.getDefaultCollapsedSubMenus(props),
    }
  }

  componentDidMount() {}
  componentWillUnmount() {
    clearTimeout(this.resizeTimeout)
  }
  onCollapse = (collapsed) => {
    this.props.dispatch({
      type: 'global/changeLayoutCollapsed',
      payload: collapsed,
    })
  }

  getDefaultCollapsedSubMenus = (props) => {
    const currentMenuSelectedKeys = [...this.getCurrentMenuSelectedKeys(props)]
    currentMenuSelectedKeys.splice(-1, 1)
    if (currentMenuSelectedKeys.length === 0) {
      return ['/platform/']
    }
    return currentMenuSelectedKeys
  }
  getCurrentMenuSelectedKeys = (props) => {
    const { location: { pathname } } = props || this.props
    const keys = pathname.split('/').slice(1)
    if (keys.length === 1 && keys[0] === '') {
      return [this.menus[0].key]
    }
    return keys
  }
  
  getNavMenuItems = (targetObject) => {
  

    const menuData = sessionObject('menuData')
    const targetApp = sessionObject('targetApp')
	const {objectId}=targetApp;
  	const userContext = null
    return (
      
		  <Menu
             theme="dark"
             mode="inline"
            
             
             onOpenChange={this.handleOpenChange}
            
             defaultOpenKeys={['firstOne']}
             style={{ margin: '16px 0', width: '100%' }}
           >
           

             <Menu.Item key="dashboard">
               <Link to={`/platform/${this.props.platform.id}/dashboard`}><Icon type="dashboard" /><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
             </Menu.Item>
             
		 <Menu.Item key="homepage">
               <Link to={"/home"}><Icon type="home" /><span>{appLocaleName(userContext,"Home")}</span></Link>
             </Menu.Item>
             
             
         {filteredMenuItems(targetObject,this).map((item)=>(<Menu.Item key={item.name}>
          <Link to={`/${menuData.menuFor}/${objectId}/list/${item.name}/${item.displayName}${appLocaleName(userContext,"List")}`}>
          <Icon type="bars" /><span>{item.displayName}</span>
          </Link>
        </Menu.Item>))}
       
       <Menu.Item key="preference">
               <Link to={`/platform/${this.props.platform.id}/preference`}><Icon type="setting" /><span>{appLocaleName(userContext,"Preference")}</span></Link>
             </Menu.Item>
      
           </Menu>
    )
  }
  



  getSiteSearch = () => {
    const {SiteSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Site",
      role: "site",
      data: state._platform.siteList,
      metaInfo: state._platform.siteListMetaInfo,
      count: state._platform.siteCount,
      currentPage: state._platform.siteCurrentPageNumber,
      searchFormParameters: state._platform.siteSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'siteList', ref:state._platform, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SiteSearch)
  }
  getSiteCreateForm = () => {
   	const {SiteCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "site",
      data: state._platform.siteList,
      metaInfo: state._platform.siteListMetaInfo,
      count: state._platform.siteCount,
      currentPage: state._platform.siteCurrentPageNumber,
      searchFormParameters: state._platform.siteSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'siteList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(SiteCreateForm)
  }
  
  getSiteUpdateForm = () => {
    const userContext = null
  	const {SiteUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "site",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'siteList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SiteUpdateForm)
  }

  getCatalogSearch = () => {
    const {CatalogSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Catalog",
      role: "catalog",
      data: state._platform.catalogList,
      metaInfo: state._platform.catalogListMetaInfo,
      count: state._platform.catalogCount,
      currentPage: state._platform.catalogCurrentPageNumber,
      searchFormParameters: state._platform.catalogSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'catalogList', ref:state._platform, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(CatalogSearch)
  }
  getCatalogCreateForm = () => {
   	const {CatalogCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "catalog",
      data: state._platform.catalogList,
      metaInfo: state._platform.catalogListMetaInfo,
      count: state._platform.catalogCount,
      currentPage: state._platform.catalogCurrentPageNumber,
      searchFormParameters: state._platform.catalogSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'catalogList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(CatalogCreateForm)
  }
  
  getCatalogUpdateForm = () => {
    const userContext = null
  	const {CatalogUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "catalog",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'catalogList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(CatalogUpdateForm)
  }

  getBrandSearch = () => {
    const {BrandSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Brand",
      role: "brand",
      data: state._platform.brandList,
      metaInfo: state._platform.brandListMetaInfo,
      count: state._platform.brandCount,
      currentPage: state._platform.brandCurrentPageNumber,
      searchFormParameters: state._platform.brandSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'brandList', ref:state._platform, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(BrandSearch)
  }
  getBrandCreateForm = () => {
   	const {BrandCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "brand",
      data: state._platform.brandList,
      metaInfo: state._platform.brandListMetaInfo,
      count: state._platform.brandCount,
      currentPage: state._platform.brandCurrentPageNumber,
      searchFormParameters: state._platform.brandSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'brandList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(BrandCreateForm)
  }
  
  getBrandUpdateForm = () => {
    const userContext = null
  	const {BrandUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "brand",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'brandList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(BrandUpdateForm)
  }

  getProductSearch = () => {
    const {ProductSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Product",
      role: "product",
      data: state._platform.productList,
      metaInfo: state._platform.productListMetaInfo,
      count: state._platform.productCount,
      currentPage: state._platform.productCurrentPageNumber,
      searchFormParameters: state._platform.productSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'productList', ref:state._platform, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ProductSearch)
  }
  getProductCreateForm = () => {
   	const {ProductCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "product",
      data: state._platform.productList,
      metaInfo: state._platform.productListMetaInfo,
      count: state._platform.productCount,
      currentPage: state._platform.productCurrentPageNumber,
      searchFormParameters: state._platform.productSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'productList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ProductCreateForm)
  }
  
  getProductUpdateForm = () => {
    const userContext = null
  	const {ProductUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "product",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'productList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ProductUpdateForm)
  }

  getBannerSearch = () => {
    const {BannerSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Banner",
      role: "banner",
      data: state._platform.bannerList,
      metaInfo: state._platform.bannerListMetaInfo,
      count: state._platform.bannerCount,
      currentPage: state._platform.bannerCurrentPageNumber,
      searchFormParameters: state._platform.bannerSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'bannerList', ref:state._platform, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(BannerSearch)
  }
  getBannerCreateForm = () => {
   	const {BannerCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "banner",
      data: state._platform.bannerList,
      metaInfo: state._platform.bannerListMetaInfo,
      count: state._platform.bannerCount,
      currentPage: state._platform.bannerCurrentPageNumber,
      searchFormParameters: state._platform.bannerSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'bannerList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(BannerCreateForm)
  }
  
  getBannerUpdateForm = () => {
    const userContext = null
  	const {BannerUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "banner",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'bannerList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(BannerUpdateForm)
  }

  getProfileSearch = () => {
    const {ProfileSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Profile",
      role: "profile",
      data: state._platform.profileList,
      metaInfo: state._platform.profileListMetaInfo,
      count: state._platform.profileCount,
      currentPage: state._platform.profileCurrentPageNumber,
      searchFormParameters: state._platform.profileSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'profileList', ref:state._platform, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ProfileSearch)
  }
  getProfileCreateForm = () => {
   	const {ProfileCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "profile",
      data: state._platform.profileList,
      metaInfo: state._platform.profileListMetaInfo,
      count: state._platform.profileCount,
      currentPage: state._platform.profileCurrentPageNumber,
      searchFormParameters: state._platform.profileSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'profileList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ProfileCreateForm)
  }
  
  getProfileUpdateForm = () => {
    const userContext = null
  	const {ProfileUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "profile",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'profileList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ProfileUpdateForm)
  }

  getUserAlertSearch = () => {
    const {UserAlertSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "User Alert",
      role: "userAlert",
      data: state._platform.userAlertList,
      metaInfo: state._platform.userAlertListMetaInfo,
      count: state._platform.userAlertCount,
      currentPage: state._platform.userAlertCurrentPageNumber,
      searchFormParameters: state._platform.userAlertSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'userAlertList', ref:state._platform, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(UserAlertSearch)
  }
  getUserAlertCreateForm = () => {
   	const {UserAlertCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "userAlert",
      data: state._platform.userAlertList,
      metaInfo: state._platform.userAlertListMetaInfo,
      count: state._platform.userAlertCount,
      currentPage: state._platform.userAlertCurrentPageNumber,
      searchFormParameters: state._platform.userAlertSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'userAlertList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(UserAlertCreateForm)
  }
  
  getUserAlertUpdateForm = () => {
    const userContext = null
  	const {UserAlertUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "userAlert",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'userAlertList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(UserAlertUpdateForm)
  }

  getNewProductSearch = () => {
    const {NewProductSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "New Product",
      role: "newProduct",
      data: state._platform.newProductList,
      metaInfo: state._platform.newProductListMetaInfo,
      count: state._platform.newProductCount,
      currentPage: state._platform.newProductCurrentPageNumber,
      searchFormParameters: state._platform.newProductSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'newProductList', ref:state._platform, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(NewProductSearch)
  }
  getNewProductCreateForm = () => {
   	const {NewProductCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "newProduct",
      data: state._platform.newProductList,
      metaInfo: state._platform.newProductListMetaInfo,
      count: state._platform.newProductCount,
      currentPage: state._platform.newProductCurrentPageNumber,
      searchFormParameters: state._platform.newProductSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'newProductList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(NewProductCreateForm)
  }
  
  getNewProductUpdateForm = () => {
    const userContext = null
  	const {NewProductUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "newProduct",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'newProductList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(NewProductUpdateForm)
  }

  getEditorPickProductSearch = () => {
    const {EditorPickProductSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Editor Pick Product",
      role: "editorPickProduct",
      data: state._platform.editorPickProductList,
      metaInfo: state._platform.editorPickProductListMetaInfo,
      count: state._platform.editorPickProductCount,
      currentPage: state._platform.editorPickProductCurrentPageNumber,
      searchFormParameters: state._platform.editorPickProductSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'editorPickProductList', ref:state._platform, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EditorPickProductSearch)
  }
  getEditorPickProductCreateForm = () => {
   	const {EditorPickProductCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "editorPickProduct",
      data: state._platform.editorPickProductList,
      metaInfo: state._platform.editorPickProductListMetaInfo,
      count: state._platform.editorPickProductCount,
      currentPage: state._platform.editorPickProductCurrentPageNumber,
      searchFormParameters: state._platform.editorPickProductSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'editorPickProductList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(EditorPickProductCreateForm)
  }
  
  getEditorPickProductUpdateForm = () => {
    const userContext = null
  	const {EditorPickProductUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "editorPickProduct",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'editorPickProductList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EditorPickProductUpdateForm)
  }

  getTopRatedProductSearch = () => {
    const {TopRatedProductSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Top Rated Product",
      role: "topRatedProduct",
      data: state._platform.topRatedProductList,
      metaInfo: state._platform.topRatedProductListMetaInfo,
      count: state._platform.topRatedProductCount,
      currentPage: state._platform.topRatedProductCurrentPageNumber,
      searchFormParameters: state._platform.topRatedProductSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'topRatedProductList', ref:state._platform, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TopRatedProductSearch)
  }
  getTopRatedProductCreateForm = () => {
   	const {TopRatedProductCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "topRatedProduct",
      data: state._platform.topRatedProductList,
      metaInfo: state._platform.topRatedProductListMetaInfo,
      count: state._platform.topRatedProductCount,
      currentPage: state._platform.topRatedProductCurrentPageNumber,
      searchFormParameters: state._platform.topRatedProductSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'topRatedProductList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(TopRatedProductCreateForm)
  }
  
  getTopRatedProductUpdateForm = () => {
    const userContext = null
  	const {TopRatedProductUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "topRatedProduct",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'topRatedProductList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TopRatedProductUpdateForm)
  }

  getRecommandProductSearch = () => {
    const {RecommandProductSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Recommand Product",
      role: "recommandProduct",
      data: state._platform.recommandProductList,
      metaInfo: state._platform.recommandProductListMetaInfo,
      count: state._platform.recommandProductCount,
      currentPage: state._platform.recommandProductCurrentPageNumber,
      searchFormParameters: state._platform.recommandProductSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'recommandProductList', ref:state._platform, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RecommandProductSearch)
  }
  getRecommandProductCreateForm = () => {
   	const {RecommandProductCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "recommandProduct",
      data: state._platform.recommandProductList,
      metaInfo: state._platform.recommandProductListMetaInfo,
      count: state._platform.recommandProductCount,
      currentPage: state._platform.recommandProductCurrentPageNumber,
      searchFormParameters: state._platform.recommandProductSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'recommandProductList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RecommandProductCreateForm)
  }
  
  getRecommandProductUpdateForm = () => {
    const userContext = null
  	const {RecommandProductUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "recommandProduct",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'recommandProductList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RecommandProductUpdateForm)
  }


  
  buildRouters = () =>{
  	const {PlatformDashboard} = GlobalComponents
  	const {PlatformPreference} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/platform/:id/dashboard", component: PlatformDashboard},
  	{path:"/platform/:id/preference", component: PlatformPreference},
  	
  	
  	
  	{path:"/platform/:id/list/siteList", component: this.getSiteSearch()},
  	{path:"/platform/:id/list/siteCreateForm", component: this.getSiteCreateForm()},
  	{path:"/platform/:id/list/siteUpdateForm", component: this.getSiteUpdateForm()},
   	
  	{path:"/platform/:id/list/catalogList", component: this.getCatalogSearch()},
  	{path:"/platform/:id/list/catalogCreateForm", component: this.getCatalogCreateForm()},
  	{path:"/platform/:id/list/catalogUpdateForm", component: this.getCatalogUpdateForm()},
   	
  	{path:"/platform/:id/list/brandList", component: this.getBrandSearch()},
  	{path:"/platform/:id/list/brandCreateForm", component: this.getBrandCreateForm()},
  	{path:"/platform/:id/list/brandUpdateForm", component: this.getBrandUpdateForm()},
   	
  	{path:"/platform/:id/list/productList", component: this.getProductSearch()},
  	{path:"/platform/:id/list/productCreateForm", component: this.getProductCreateForm()},
  	{path:"/platform/:id/list/productUpdateForm", component: this.getProductUpdateForm()},
   	
  	{path:"/platform/:id/list/bannerList", component: this.getBannerSearch()},
  	{path:"/platform/:id/list/bannerCreateForm", component: this.getBannerCreateForm()},
  	{path:"/platform/:id/list/bannerUpdateForm", component: this.getBannerUpdateForm()},
   	
  	{path:"/platform/:id/list/profileList", component: this.getProfileSearch()},
  	{path:"/platform/:id/list/profileCreateForm", component: this.getProfileCreateForm()},
  	{path:"/platform/:id/list/profileUpdateForm", component: this.getProfileUpdateForm()},
   	
  	{path:"/platform/:id/list/userAlertList", component: this.getUserAlertSearch()},
  	{path:"/platform/:id/list/userAlertCreateForm", component: this.getUserAlertCreateForm()},
  	{path:"/platform/:id/list/userAlertUpdateForm", component: this.getUserAlertUpdateForm()},
   	
  	{path:"/platform/:id/list/newProductList", component: this.getNewProductSearch()},
  	{path:"/platform/:id/list/newProductCreateForm", component: this.getNewProductCreateForm()},
  	{path:"/platform/:id/list/newProductUpdateForm", component: this.getNewProductUpdateForm()},
   	
  	{path:"/platform/:id/list/editorPickProductList", component: this.getEditorPickProductSearch()},
  	{path:"/platform/:id/list/editorPickProductCreateForm", component: this.getEditorPickProductCreateForm()},
  	{path:"/platform/:id/list/editorPickProductUpdateForm", component: this.getEditorPickProductUpdateForm()},
   	
  	{path:"/platform/:id/list/topRatedProductList", component: this.getTopRatedProductSearch()},
  	{path:"/platform/:id/list/topRatedProductCreateForm", component: this.getTopRatedProductCreateForm()},
  	{path:"/platform/:id/list/topRatedProductUpdateForm", component: this.getTopRatedProductUpdateForm()},
   	
  	{path:"/platform/:id/list/recommandProductList", component: this.getRecommandProductSearch()},
  	{path:"/platform/:id/list/recommandProductCreateForm", component: this.getRecommandProductCreateForm()},
  	{path:"/platform/:id/list/recommandProductUpdateForm", component: this.getRecommandProductUpdateForm()},
     	
  	
  	]
  	
  	const {extraRoutesFunc} = this.props;
	const extraRoutes = extraRoutesFunc?extraRoutesFunc():[]
    const finalRoutes = routers.concat(extraRoutes)
    
  	return (<Switch>
             {finalRoutes.map((item)=>(<Route key={item.path} path={item.path} component={item.component} />))}    
  	  	</Switch>)
  	
  
  }
 

  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = 'User Experience Service'
    return title
  }
 
  handleOpenChange = (openKeys) => {
    const latestOpenKey = openKeys.find(key => this.state.openKeys.indexOf(key) === -1)
    this.setState({
      openKeys: latestOpenKey ? [latestOpenKey] : [],
    })
  }
   toggle = () => {
     const { collapsed } = this.props
     this.props.dispatch({
       type: 'global/changeLayoutCollapsed',
       payload: !collapsed,
     })
   }
    logout = () => {
   
    console.log("log out called")
    this.props.dispatch({ type: 'launcher/signOut' })
  }
   render() {
     // const { collapsed, fetchingNotices,loading } = this.props
     const { collapsed } = this.props
     const { breadcrumb }  = this.props
  
     const targetApp = sessionObject('targetApp')
     const currentBreadcrumb =sessionObject(targetApp.id)
     const userContext = null
     
     const menuProps = collapsed ? {} : {
       openKeys: this.state.openKeys,
     }
     const layout = (
     <Layout>
        <Header>
          
          <div className={styles.left}>
          <img
            src="./favicon.png"
            alt="logo"
            onClick={this.toggle}
            className={styles.logo}
          />
          {currentBreadcrumb.map((item)=>{
            return (<Link  key={item.link} to={`${item.link}`} className={styles.breadcrumbLink}> &gt;{item.name}</Link>)

          })}
         </div>
          <div className={styles.right}  >
          <Button type="primary"  icon="logout" onClick={()=>this.logout()}>
          {appLocaleName(userContext,"Exit")}</Button>
          </div>
          
        </Header>
       <Layout>
         <Sider
           trigger={null}
           collapsible
           collapsed={collapsed}
           breakpoint="md"
           onCollapse={()=>this.onCollapse(collapsed)}
           collapsedWidth={56}
           className={styles.sider}
         >

		 {this.getNavMenuItems(this.props.platform)}
		 
         </Sider>
         <Layout>
           <Content style={{ margin: '24px 24px 0', height: '100%' }}>
           
           {this.buildRouters()}
 
             
             
           </Content>
          </Layout>
        </Layout>
      </Layout>
     )
     return (
       <DocumentTitle title={this.getPageTitle()}>
         <ContainerQuery query={query}>
           {params => <div className={classNames(params)}>{layout}</div>}
         </ContainerQuery>
       </DocumentTitle>
     )
   }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
  fetchingNotices: state.global.fetchingNotices,
  notices: state.global.notices,
  platform: state._platform,
  ...state,
}))(PlatformBizApp)



