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
import styles from './Profile.app.less'
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




class ProfileBizApp extends React.PureComponent {
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
      return ['/profile/']
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
               <Link to={`/profile/${this.props.profile.id}/dashboard`}><Icon type="dashboard" /><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
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
               <Link to={`/profile/${this.props.profile.id}/preference`}><Icon type="setting" /><span>{appLocaleName(userContext,"Preference")}</span></Link>
             </Menu.Item>
      
           </Menu>
    )
  }
  



  getTargetSearch = () => {
    const {TargetSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Target",
      role: "target",
      data: state._profile.targetList,
      metaInfo: state._profile.targetListMetaInfo,
      count: state._profile.targetCount,
      currentPage: state._profile.targetCurrentPageNumber,
      searchFormParameters: state._profile.targetSearchFormParameters,
      searchParameters: {...state._profile.searchParameters},
      expandForm: state._profile.expandForm,
      loading: state._profile.loading,
      partialList: state._profile.partialList,
      owner: { type: '_profile', id: state._profile.id, 
      referenceName: 'profile', 
      listName: 'targetList', ref:state._profile, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TargetSearch)
  }
  getTargetCreateForm = () => {
   	const {TargetCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "target",
      data: state._profile.targetList,
      metaInfo: state._profile.targetListMetaInfo,
      count: state._profile.targetCount,
      currentPage: state._profile.targetCurrentPageNumber,
      searchFormParameters: state._profile.targetSearchFormParameters,
      loading: state._profile.loading,
      owner: { type: '_profile', id: state._profile.id, referenceName: 'profile', listName: 'targetList', ref:state._profile, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(TargetCreateForm)
  }
  
  getTargetUpdateForm = () => {
    const userContext = null
  	const {TargetUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._profile.selectedRows,
      role: "target",
      currentUpdateIndex: state._profile.currentUpdateIndex,
      owner: { type: '_profile', id: state._profile.id, listName: 'targetList', ref:state._profile, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TargetUpdateForm)
  }

  getRatingSearch = () => {
    const {RatingSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Rating",
      role: "rating",
      data: state._profile.ratingList,
      metaInfo: state._profile.ratingListMetaInfo,
      count: state._profile.ratingCount,
      currentPage: state._profile.ratingCurrentPageNumber,
      searchFormParameters: state._profile.ratingSearchFormParameters,
      searchParameters: {...state._profile.searchParameters},
      expandForm: state._profile.expandForm,
      loading: state._profile.loading,
      partialList: state._profile.partialList,
      owner: { type: '_profile', id: state._profile.id, 
      referenceName: 'user', 
      listName: 'ratingList', ref:state._profile, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RatingSearch)
  }
  getRatingCreateForm = () => {
   	const {RatingCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "rating",
      data: state._profile.ratingList,
      metaInfo: state._profile.ratingListMetaInfo,
      count: state._profile.ratingCount,
      currentPage: state._profile.ratingCurrentPageNumber,
      searchFormParameters: state._profile.ratingSearchFormParameters,
      loading: state._profile.loading,
      owner: { type: '_profile', id: state._profile.id, referenceName: 'user', listName: 'ratingList', ref:state._profile, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(RatingCreateForm)
  }
  
  getRatingUpdateForm = () => {
    const userContext = null
  	const {RatingUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._profile.selectedRows,
      role: "rating",
      currentUpdateIndex: state._profile.currentUpdateIndex,
      owner: { type: '_profile', id: state._profile.id, listName: 'ratingList', ref:state._profile, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(RatingUpdateForm)
  }

  getReviewSearch = () => {
    const {ReviewSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Review",
      role: "review",
      data: state._profile.reviewList,
      metaInfo: state._profile.reviewListMetaInfo,
      count: state._profile.reviewCount,
      currentPage: state._profile.reviewCurrentPageNumber,
      searchFormParameters: state._profile.reviewSearchFormParameters,
      searchParameters: {...state._profile.searchParameters},
      expandForm: state._profile.expandForm,
      loading: state._profile.loading,
      partialList: state._profile.partialList,
      owner: { type: '_profile', id: state._profile.id, 
      referenceName: 'user', 
      listName: 'reviewList', ref:state._profile, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ReviewSearch)
  }
  getReviewCreateForm = () => {
   	const {ReviewCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "review",
      data: state._profile.reviewList,
      metaInfo: state._profile.reviewListMetaInfo,
      count: state._profile.reviewCount,
      currentPage: state._profile.reviewCurrentPageNumber,
      searchFormParameters: state._profile.reviewSearchFormParameters,
      loading: state._profile.loading,
      owner: { type: '_profile', id: state._profile.id, referenceName: 'user', listName: 'reviewList', ref:state._profile, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ReviewCreateForm)
  }
  
  getReviewUpdateForm = () => {
    const userContext = null
  	const {ReviewUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._profile.selectedRows,
      role: "review",
      currentUpdateIndex: state._profile.currentUpdateIndex,
      owner: { type: '_profile', id: state._profile.id, listName: 'reviewList', ref:state._profile, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ReviewUpdateForm)
  }

  getBlogSearch = () => {
    const {BlogSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Blog",
      role: "blog",
      data: state._profile.blogList,
      metaInfo: state._profile.blogListMetaInfo,
      count: state._profile.blogCount,
      currentPage: state._profile.blogCurrentPageNumber,
      searchFormParameters: state._profile.blogSearchFormParameters,
      searchParameters: {...state._profile.searchParameters},
      expandForm: state._profile.expandForm,
      loading: state._profile.loading,
      partialList: state._profile.partialList,
      owner: { type: '_profile', id: state._profile.id, 
      referenceName: 'user', 
      listName: 'blogList', ref:state._profile, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(BlogSearch)
  }
  getBlogCreateForm = () => {
   	const {BlogCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "blog",
      data: state._profile.blogList,
      metaInfo: state._profile.blogListMetaInfo,
      count: state._profile.blogCount,
      currentPage: state._profile.blogCurrentPageNumber,
      searchFormParameters: state._profile.blogSearchFormParameters,
      loading: state._profile.loading,
      owner: { type: '_profile', id: state._profile.id, referenceName: 'user', listName: 'blogList', ref:state._profile, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(BlogCreateForm)
  }
  
  getBlogUpdateForm = () => {
    const userContext = null
  	const {BlogUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._profile.selectedRows,
      role: "blog",
      currentUpdateIndex: state._profile.currentUpdateIndex,
      owner: { type: '_profile', id: state._profile.id, listName: 'blogList', ref:state._profile, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(BlogUpdateForm)
  }


  
  buildRouters = () =>{
  	const {ProfileDashboard} = GlobalComponents
  	const {ProfilePreference} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/profile/:id/dashboard", component: ProfileDashboard},
  	{path:"/profile/:id/preference", component: ProfilePreference},
  	
  	
  	
  	{path:"/profile/:id/list/targetList", component: this.getTargetSearch()},
  	{path:"/profile/:id/list/targetCreateForm", component: this.getTargetCreateForm()},
  	{path:"/profile/:id/list/targetUpdateForm", component: this.getTargetUpdateForm()},
   	
  	{path:"/profile/:id/list/ratingList", component: this.getRatingSearch()},
  	{path:"/profile/:id/list/ratingCreateForm", component: this.getRatingCreateForm()},
  	{path:"/profile/:id/list/ratingUpdateForm", component: this.getRatingUpdateForm()},
   	
  	{path:"/profile/:id/list/reviewList", component: this.getReviewSearch()},
  	{path:"/profile/:id/list/reviewCreateForm", component: this.getReviewCreateForm()},
  	{path:"/profile/:id/list/reviewUpdateForm", component: this.getReviewUpdateForm()},
   	
  	{path:"/profile/:id/list/blogList", component: this.getBlogSearch()},
  	{path:"/profile/:id/list/blogCreateForm", component: this.getBlogCreateForm()},
  	{path:"/profile/:id/list/blogUpdateForm", component: this.getBlogUpdateForm()},
     	
  	
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

		 {this.getNavMenuItems(this.props.profile)}
		 
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
  profile: state._profile,
  ...state,
}))(ProfileBizApp)



