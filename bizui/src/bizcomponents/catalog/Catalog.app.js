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
import styles from './Catalog.app.less'
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




class CatalogBizApp extends React.PureComponent {
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
      return ['/catalog/']
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
               <Link to={`/catalog/${this.props.catalog.id}/dashboard`}><Icon type="dashboard" /><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
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
               <Link to={`/catalog/${this.props.catalog.id}/preference`}><Icon type="setting" /><span>{appLocaleName(userContext,"Preference")}</span></Link>
             </Menu.Item>
      
           </Menu>
    )
  }
  



  getLevelOneCategorySearch = () => {
    const {LevelOneCategorySearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Level One Category",
      role: "levelOneCategory",
      data: state._catalog.levelOneCategoryList,
      metaInfo: state._catalog.levelOneCategoryListMetaInfo,
      count: state._catalog.levelOneCategoryCount,
      currentPage: state._catalog.levelOneCategoryCurrentPageNumber,
      searchFormParameters: state._catalog.levelOneCategorySearchFormParameters,
      searchParameters: {...state._catalog.searchParameters},
      expandForm: state._catalog.expandForm,
      loading: state._catalog.loading,
      partialList: state._catalog.partialList,
      owner: { type: '_catalog', id: state._catalog.id, 
      referenceName: 'catalog', 
      listName: 'levelOneCategoryList', ref:state._catalog, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(LevelOneCategorySearch)
  }
  getLevelOneCategoryCreateForm = () => {
   	const {LevelOneCategoryCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "levelOneCategory",
      data: state._catalog.levelOneCategoryList,
      metaInfo: state._catalog.levelOneCategoryListMetaInfo,
      count: state._catalog.levelOneCategoryCount,
      currentPage: state._catalog.levelOneCategoryCurrentPageNumber,
      searchFormParameters: state._catalog.levelOneCategorySearchFormParameters,
      loading: state._catalog.loading,
      owner: { type: '_catalog', id: state._catalog.id, referenceName: 'catalog', listName: 'levelOneCategoryList', ref:state._catalog, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(LevelOneCategoryCreateForm)
  }
  
  getLevelOneCategoryUpdateForm = () => {
    const userContext = null
  	const {LevelOneCategoryUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._catalog.selectedRows,
      role: "levelOneCategory",
      currentUpdateIndex: state._catalog.currentUpdateIndex,
      owner: { type: '_catalog', id: state._catalog.id, listName: 'levelOneCategoryList', ref:state._catalog, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(LevelOneCategoryUpdateForm)
  }

  getProductSearch = () => {
    const {ProductSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Product",
      role: "product",
      data: state._catalog.productList,
      metaInfo: state._catalog.productListMetaInfo,
      count: state._catalog.productCount,
      currentPage: state._catalog.productCurrentPageNumber,
      searchFormParameters: state._catalog.productSearchFormParameters,
      searchParameters: {...state._catalog.searchParameters},
      expandForm: state._catalog.expandForm,
      loading: state._catalog.loading,
      partialList: state._catalog.partialList,
      owner: { type: '_catalog', id: state._catalog.id, 
      referenceName: 'catalog', 
      listName: 'productList', ref:state._catalog, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ProductSearch)
  }
  getProductCreateForm = () => {
   	const {ProductCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "product",
      data: state._catalog.productList,
      metaInfo: state._catalog.productListMetaInfo,
      count: state._catalog.productCount,
      currentPage: state._catalog.productCurrentPageNumber,
      searchFormParameters: state._catalog.productSearchFormParameters,
      loading: state._catalog.loading,
      owner: { type: '_catalog', id: state._catalog.id, referenceName: 'catalog', listName: 'productList', ref:state._catalog, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ProductCreateForm)
  }
  
  getProductUpdateForm = () => {
    const userContext = null
  	const {ProductUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._catalog.selectedRows,
      role: "product",
      currentUpdateIndex: state._catalog.currentUpdateIndex,
      owner: { type: '_catalog', id: state._catalog.id, listName: 'productList', ref:state._catalog, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ProductUpdateForm)
  }

  getNewProductSearch = () => {
    const {NewProductSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "New Product",
      role: "newProduct",
      data: state._catalog.newProductList,
      metaInfo: state._catalog.newProductListMetaInfo,
      count: state._catalog.newProductCount,
      currentPage: state._catalog.newProductCurrentPageNumber,
      searchFormParameters: state._catalog.newProductSearchFormParameters,
      searchParameters: {...state._catalog.searchParameters},
      expandForm: state._catalog.expandForm,
      loading: state._catalog.loading,
      partialList: state._catalog.partialList,
      owner: { type: '_catalog', id: state._catalog.id, 
      referenceName: 'catalog', 
      listName: 'newProductList', ref:state._catalog, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(NewProductSearch)
  }
  getNewProductCreateForm = () => {
   	const {NewProductCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "newProduct",
      data: state._catalog.newProductList,
      metaInfo: state._catalog.newProductListMetaInfo,
      count: state._catalog.newProductCount,
      currentPage: state._catalog.newProductCurrentPageNumber,
      searchFormParameters: state._catalog.newProductSearchFormParameters,
      loading: state._catalog.loading,
      owner: { type: '_catalog', id: state._catalog.id, referenceName: 'catalog', listName: 'newProductList', ref:state._catalog, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(NewProductCreateForm)
  }
  
  getNewProductUpdateForm = () => {
    const userContext = null
  	const {NewProductUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._catalog.selectedRows,
      role: "newProduct",
      currentUpdateIndex: state._catalog.currentUpdateIndex,
      owner: { type: '_catalog', id: state._catalog.id, listName: 'newProductList', ref:state._catalog, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(NewProductUpdateForm)
  }

  getEditorPickProductSearch = () => {
    const {EditorPickProductSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Editor Pick Product",
      role: "editorPickProduct",
      data: state._catalog.editorPickProductList,
      metaInfo: state._catalog.editorPickProductListMetaInfo,
      count: state._catalog.editorPickProductCount,
      currentPage: state._catalog.editorPickProductCurrentPageNumber,
      searchFormParameters: state._catalog.editorPickProductSearchFormParameters,
      searchParameters: {...state._catalog.searchParameters},
      expandForm: state._catalog.expandForm,
      loading: state._catalog.loading,
      partialList: state._catalog.partialList,
      owner: { type: '_catalog', id: state._catalog.id, 
      referenceName: 'catalog', 
      listName: 'editorPickProductList', ref:state._catalog, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EditorPickProductSearch)
  }
  getEditorPickProductCreateForm = () => {
   	const {EditorPickProductCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "editorPickProduct",
      data: state._catalog.editorPickProductList,
      metaInfo: state._catalog.editorPickProductListMetaInfo,
      count: state._catalog.editorPickProductCount,
      currentPage: state._catalog.editorPickProductCurrentPageNumber,
      searchFormParameters: state._catalog.editorPickProductSearchFormParameters,
      loading: state._catalog.loading,
      owner: { type: '_catalog', id: state._catalog.id, referenceName: 'catalog', listName: 'editorPickProductList', ref:state._catalog, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(EditorPickProductCreateForm)
  }
  
  getEditorPickProductUpdateForm = () => {
    const userContext = null
  	const {EditorPickProductUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._catalog.selectedRows,
      role: "editorPickProduct",
      currentUpdateIndex: state._catalog.currentUpdateIndex,
      owner: { type: '_catalog', id: state._catalog.id, listName: 'editorPickProductList', ref:state._catalog, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(EditorPickProductUpdateForm)
  }

  getTopRatedProductSearch = () => {
    const {TopRatedProductSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Top Rated Product",
      role: "topRatedProduct",
      data: state._catalog.topRatedProductList,
      metaInfo: state._catalog.topRatedProductListMetaInfo,
      count: state._catalog.topRatedProductCount,
      currentPage: state._catalog.topRatedProductCurrentPageNumber,
      searchFormParameters: state._catalog.topRatedProductSearchFormParameters,
      searchParameters: {...state._catalog.searchParameters},
      expandForm: state._catalog.expandForm,
      loading: state._catalog.loading,
      partialList: state._catalog.partialList,
      owner: { type: '_catalog', id: state._catalog.id, 
      referenceName: 'catalog', 
      listName: 'topRatedProductList', ref:state._catalog, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TopRatedProductSearch)
  }
  getTopRatedProductCreateForm = () => {
   	const {TopRatedProductCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "topRatedProduct",
      data: state._catalog.topRatedProductList,
      metaInfo: state._catalog.topRatedProductListMetaInfo,
      count: state._catalog.topRatedProductCount,
      currentPage: state._catalog.topRatedProductCurrentPageNumber,
      searchFormParameters: state._catalog.topRatedProductSearchFormParameters,
      loading: state._catalog.loading,
      owner: { type: '_catalog', id: state._catalog.id, referenceName: 'catalog', listName: 'topRatedProductList', ref:state._catalog, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(TopRatedProductCreateForm)
  }
  
  getTopRatedProductUpdateForm = () => {
    const userContext = null
  	const {TopRatedProductUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._catalog.selectedRows,
      role: "topRatedProduct",
      currentUpdateIndex: state._catalog.currentUpdateIndex,
      owner: { type: '_catalog', id: state._catalog.id, listName: 'topRatedProductList', ref:state._catalog, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TopRatedProductUpdateForm)
  }

  getRecommandProductSearch = () => {
    const {RecommandProductSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Recommand Product",
      role: "recommandProduct",
      data: state._catalog.recommandProductList,
      metaInfo: state._catalog.recommandProductListMetaInfo,
      count: state._catalog.recommandProductCount,
      currentPage: state._catalog.recommandProductCurrentPageNumber,
      searchFormParameters: state._catalog.recommandProductSearchFormParameters,
      searchParameters: {...state._catalog.searchParameters},
      expandForm: state._catalog.expandForm,
      loading: state._catalog.loading,
      partialList: state._catalog.partialList,
      owner: { type: '_catalog', id: state._catalog.id, 
      referenceName: 'catalog', 
      listName: 'recommandProductList', ref:state._catalog, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RecommandProductSearch)
  }
  getRecommandProductCreateForm = () => {
   	const {RecommandProductCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "recommandProduct",
      data: state._catalog.recommandProductList,
      metaInfo: state._catalog.recommandProductListMetaInfo,
      count: state._catalog.recommandProductCount,
      currentPage: state._catalog.recommandProductCurrentPageNumber,
      searchFormParameters: state._catalog.recommandProductSearchFormParameters,
      loading: state._catalog.loading,
      owner: { type: '_catalog', id: state._catalog.id, referenceName: 'catalog', listName: 'recommandProductList', ref:state._catalog, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RecommandProductCreateForm)
  }
  
  getRecommandProductUpdateForm = () => {
    const userContext = null
  	const {RecommandProductUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._catalog.selectedRows,
      role: "recommandProduct",
      currentUpdateIndex: state._catalog.currentUpdateIndex,
      owner: { type: '_catalog', id: state._catalog.id, listName: 'recommandProductList', ref:state._catalog, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RecommandProductUpdateForm)
  }


  
  buildRouters = () =>{
  	const {CatalogDashboard} = GlobalComponents
  	const {CatalogPreference} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/catalog/:id/dashboard", component: CatalogDashboard},
  	{path:"/catalog/:id/preference", component: CatalogPreference},
  	
  	
  	
  	{path:"/catalog/:id/list/levelOneCategoryList", component: this.getLevelOneCategorySearch()},
  	{path:"/catalog/:id/list/levelOneCategoryCreateForm", component: this.getLevelOneCategoryCreateForm()},
  	{path:"/catalog/:id/list/levelOneCategoryUpdateForm", component: this.getLevelOneCategoryUpdateForm()},
   	
  	{path:"/catalog/:id/list/productList", component: this.getProductSearch()},
  	{path:"/catalog/:id/list/productCreateForm", component: this.getProductCreateForm()},
  	{path:"/catalog/:id/list/productUpdateForm", component: this.getProductUpdateForm()},
   	
  	{path:"/catalog/:id/list/newProductList", component: this.getNewProductSearch()},
  	{path:"/catalog/:id/list/newProductCreateForm", component: this.getNewProductCreateForm()},
  	{path:"/catalog/:id/list/newProductUpdateForm", component: this.getNewProductUpdateForm()},
   	
  	{path:"/catalog/:id/list/editorPickProductList", component: this.getEditorPickProductSearch()},
  	{path:"/catalog/:id/list/editorPickProductCreateForm", component: this.getEditorPickProductCreateForm()},
  	{path:"/catalog/:id/list/editorPickProductUpdateForm", component: this.getEditorPickProductUpdateForm()},
   	
  	{path:"/catalog/:id/list/topRatedProductList", component: this.getTopRatedProductSearch()},
  	{path:"/catalog/:id/list/topRatedProductCreateForm", component: this.getTopRatedProductCreateForm()},
  	{path:"/catalog/:id/list/topRatedProductUpdateForm", component: this.getTopRatedProductUpdateForm()},
   	
  	{path:"/catalog/:id/list/recommandProductList", component: this.getRecommandProductSearch()},
  	{path:"/catalog/:id/list/recommandProductCreateForm", component: this.getRecommandProductCreateForm()},
  	{path:"/catalog/:id/list/recommandProductUpdateForm", component: this.getRecommandProductUpdateForm()},
     	
  	
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

		 {this.getNavMenuItems(this.props.catalog)}
		 
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
  catalog: state._catalog,
  ...state,
}))(CatalogBizApp)



