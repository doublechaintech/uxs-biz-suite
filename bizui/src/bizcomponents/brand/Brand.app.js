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
import styles from './Brand.app.less'
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




class BrandBizApp extends React.PureComponent {
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
      return ['/brand/']
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
               <Link to={`/brand/${this.props.brand.id}/dashboard`}><Icon type="dashboard" /><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
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
               <Link to={`/brand/${this.props.brand.id}/preference`}><Icon type="setting" /><span>{appLocaleName(userContext,"Preference")}</span></Link>
             </Menu.Item>
      
           </Menu>
    )
  }
  



  getProductSearch = () => {
    const {ProductSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Product",
      role: "product",
      data: state._brand.productList,
      metaInfo: state._brand.productListMetaInfo,
      count: state._brand.productCount,
      currentPage: state._brand.productCurrentPageNumber,
      searchFormParameters: state._brand.productSearchFormParameters,
      searchParameters: {...state._brand.searchParameters},
      expandForm: state._brand.expandForm,
      loading: state._brand.loading,
      partialList: state._brand.partialList,
      owner: { type: '_brand', id: state._brand.id, 
      referenceName: 'brand', 
      listName: 'productList', ref:state._brand, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ProductSearch)
  }
  getProductCreateForm = () => {
   	const {ProductCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "product",
      data: state._brand.productList,
      metaInfo: state._brand.productListMetaInfo,
      count: state._brand.productCount,
      currentPage: state._brand.productCurrentPageNumber,
      searchFormParameters: state._brand.productSearchFormParameters,
      loading: state._brand.loading,
      owner: { type: '_brand', id: state._brand.id, referenceName: 'brand', listName: 'productList', ref:state._brand, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ProductCreateForm)
  }
  
  getProductUpdateForm = () => {
    const userContext = null
  	const {ProductUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._brand.selectedRows,
      role: "product",
      currentUpdateIndex: state._brand.currentUpdateIndex,
      owner: { type: '_brand', id: state._brand.id, listName: 'productList', ref:state._brand, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ProductUpdateForm)
  }

  getNewProductSearch = () => {
    const {NewProductSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "New Product",
      role: "newProduct",
      data: state._brand.newProductList,
      metaInfo: state._brand.newProductListMetaInfo,
      count: state._brand.newProductCount,
      currentPage: state._brand.newProductCurrentPageNumber,
      searchFormParameters: state._brand.newProductSearchFormParameters,
      searchParameters: {...state._brand.searchParameters},
      expandForm: state._brand.expandForm,
      loading: state._brand.loading,
      partialList: state._brand.partialList,
      owner: { type: '_brand', id: state._brand.id, 
      referenceName: 'brand', 
      listName: 'newProductList', ref:state._brand, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(NewProductSearch)
  }
  getNewProductCreateForm = () => {
   	const {NewProductCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "newProduct",
      data: state._brand.newProductList,
      metaInfo: state._brand.newProductListMetaInfo,
      count: state._brand.newProductCount,
      currentPage: state._brand.newProductCurrentPageNumber,
      searchFormParameters: state._brand.newProductSearchFormParameters,
      loading: state._brand.loading,
      owner: { type: '_brand', id: state._brand.id, referenceName: 'brand', listName: 'newProductList', ref:state._brand, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(NewProductCreateForm)
  }
  
  getNewProductUpdateForm = () => {
    const userContext = null
  	const {NewProductUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._brand.selectedRows,
      role: "newProduct",
      currentUpdateIndex: state._brand.currentUpdateIndex,
      owner: { type: '_brand', id: state._brand.id, listName: 'newProductList', ref:state._brand, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(NewProductUpdateForm)
  }

  getEditorPickProductSearch = () => {
    const {EditorPickProductSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Editor Pick Product",
      role: "editorPickProduct",
      data: state._brand.editorPickProductList,
      metaInfo: state._brand.editorPickProductListMetaInfo,
      count: state._brand.editorPickProductCount,
      currentPage: state._brand.editorPickProductCurrentPageNumber,
      searchFormParameters: state._brand.editorPickProductSearchFormParameters,
      searchParameters: {...state._brand.searchParameters},
      expandForm: state._brand.expandForm,
      loading: state._brand.loading,
      partialList: state._brand.partialList,
      owner: { type: '_brand', id: state._brand.id, 
      referenceName: 'brand', 
      listName: 'editorPickProductList', ref:state._brand, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EditorPickProductSearch)
  }
  getEditorPickProductCreateForm = () => {
   	const {EditorPickProductCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "editorPickProduct",
      data: state._brand.editorPickProductList,
      metaInfo: state._brand.editorPickProductListMetaInfo,
      count: state._brand.editorPickProductCount,
      currentPage: state._brand.editorPickProductCurrentPageNumber,
      searchFormParameters: state._brand.editorPickProductSearchFormParameters,
      loading: state._brand.loading,
      owner: { type: '_brand', id: state._brand.id, referenceName: 'brand', listName: 'editorPickProductList', ref:state._brand, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(EditorPickProductCreateForm)
  }
  
  getEditorPickProductUpdateForm = () => {
    const userContext = null
  	const {EditorPickProductUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._brand.selectedRows,
      role: "editorPickProduct",
      currentUpdateIndex: state._brand.currentUpdateIndex,
      owner: { type: '_brand', id: state._brand.id, listName: 'editorPickProductList', ref:state._brand, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EditorPickProductUpdateForm)
  }

  getTopRatedProductSearch = () => {
    const {TopRatedProductSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Top Rated Product",
      role: "topRatedProduct",
      data: state._brand.topRatedProductList,
      metaInfo: state._brand.topRatedProductListMetaInfo,
      count: state._brand.topRatedProductCount,
      currentPage: state._brand.topRatedProductCurrentPageNumber,
      searchFormParameters: state._brand.topRatedProductSearchFormParameters,
      searchParameters: {...state._brand.searchParameters},
      expandForm: state._brand.expandForm,
      loading: state._brand.loading,
      partialList: state._brand.partialList,
      owner: { type: '_brand', id: state._brand.id, 
      referenceName: 'brand', 
      listName: 'topRatedProductList', ref:state._brand, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TopRatedProductSearch)
  }
  getTopRatedProductCreateForm = () => {
   	const {TopRatedProductCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "topRatedProduct",
      data: state._brand.topRatedProductList,
      metaInfo: state._brand.topRatedProductListMetaInfo,
      count: state._brand.topRatedProductCount,
      currentPage: state._brand.topRatedProductCurrentPageNumber,
      searchFormParameters: state._brand.topRatedProductSearchFormParameters,
      loading: state._brand.loading,
      owner: { type: '_brand', id: state._brand.id, referenceName: 'brand', listName: 'topRatedProductList', ref:state._brand, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(TopRatedProductCreateForm)
  }
  
  getTopRatedProductUpdateForm = () => {
    const userContext = null
  	const {TopRatedProductUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._brand.selectedRows,
      role: "topRatedProduct",
      currentUpdateIndex: state._brand.currentUpdateIndex,
      owner: { type: '_brand', id: state._brand.id, listName: 'topRatedProductList', ref:state._brand, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TopRatedProductUpdateForm)
  }

  getRecommandProductSearch = () => {
    const {RecommandProductSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Recommand Product",
      role: "recommandProduct",
      data: state._brand.recommandProductList,
      metaInfo: state._brand.recommandProductListMetaInfo,
      count: state._brand.recommandProductCount,
      currentPage: state._brand.recommandProductCurrentPageNumber,
      searchFormParameters: state._brand.recommandProductSearchFormParameters,
      searchParameters: {...state._brand.searchParameters},
      expandForm: state._brand.expandForm,
      loading: state._brand.loading,
      partialList: state._brand.partialList,
      owner: { type: '_brand', id: state._brand.id, 
      referenceName: 'brand', 
      listName: 'recommandProductList', ref:state._brand, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RecommandProductSearch)
  }
  getRecommandProductCreateForm = () => {
   	const {RecommandProductCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "recommandProduct",
      data: state._brand.recommandProductList,
      metaInfo: state._brand.recommandProductListMetaInfo,
      count: state._brand.recommandProductCount,
      currentPage: state._brand.recommandProductCurrentPageNumber,
      searchFormParameters: state._brand.recommandProductSearchFormParameters,
      loading: state._brand.loading,
      owner: { type: '_brand', id: state._brand.id, referenceName: 'brand', listName: 'recommandProductList', ref:state._brand, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RecommandProductCreateForm)
  }
  
  getRecommandProductUpdateForm = () => {
    const userContext = null
  	const {RecommandProductUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._brand.selectedRows,
      role: "recommandProduct",
      currentUpdateIndex: state._brand.currentUpdateIndex,
      owner: { type: '_brand', id: state._brand.id, listName: 'recommandProductList', ref:state._brand, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RecommandProductUpdateForm)
  }


  
  buildRouters = () =>{
  	const {BrandDashboard} = GlobalComponents
  	const {BrandPreference} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/brand/:id/dashboard", component: BrandDashboard},
  	{path:"/brand/:id/preference", component: BrandPreference},
  	
  	
  	
  	{path:"/brand/:id/list/productList", component: this.getProductSearch()},
  	{path:"/brand/:id/list/productCreateForm", component: this.getProductCreateForm()},
  	{path:"/brand/:id/list/productUpdateForm", component: this.getProductUpdateForm()},
   	
  	{path:"/brand/:id/list/newProductList", component: this.getNewProductSearch()},
  	{path:"/brand/:id/list/newProductCreateForm", component: this.getNewProductCreateForm()},
  	{path:"/brand/:id/list/newProductUpdateForm", component: this.getNewProductUpdateForm()},
   	
  	{path:"/brand/:id/list/editorPickProductList", component: this.getEditorPickProductSearch()},
  	{path:"/brand/:id/list/editorPickProductCreateForm", component: this.getEditorPickProductCreateForm()},
  	{path:"/brand/:id/list/editorPickProductUpdateForm", component: this.getEditorPickProductUpdateForm()},
   	
  	{path:"/brand/:id/list/topRatedProductList", component: this.getTopRatedProductSearch()},
  	{path:"/brand/:id/list/topRatedProductCreateForm", component: this.getTopRatedProductCreateForm()},
  	{path:"/brand/:id/list/topRatedProductUpdateForm", component: this.getTopRatedProductUpdateForm()},
   	
  	{path:"/brand/:id/list/recommandProductList", component: this.getRecommandProductSearch()},
  	{path:"/brand/:id/list/recommandProductCreateForm", component: this.getRecommandProductCreateForm()},
  	{path:"/brand/:id/list/recommandProductUpdateForm", component: this.getRecommandProductUpdateForm()},
     	
  	
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

		 {this.getNavMenuItems(this.props.brand)}
		 
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
  brand: state._brand,
  ...state,
}))(BrandBizApp)



